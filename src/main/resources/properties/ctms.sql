/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50704
Source Host           : 127.0.0.1:3306
Source Database       : ctms

Target Server Type    : MYSQL
Target Server Version : 50704
File Encoding         : 65001

Date: 2017-05-15 21:45:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_num` int(10) NOT NULL,
  `employee_name` varchar(30) NOT NULL,
  `reason` varchar(255) NOT NULL COMMENT '出差事由',
  `dept_id` int(10) NOT NULL,
  `start_date` date NOT NULL COMMENT '出差开始时间',
  `end_date` date DEFAULT NULL COMMENT '出差结束时间',
  `destination` varchar(255) NOT NULL,
  `vehicle` varchar(20) NOT NULL,
  `traffic_fee` double(10,2) NOT NULL,
  `accomodation` double(10,2) NOT NULL COMMENT '住宿费',
  `deleted_mark` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0(正常);1(已删除)',
  `check_state` int(4) NOT NULL DEFAULT '0' COMMENT '0：未审核 -1:未通过 10：部门经理 20：财务经历 30：行政经理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('1', '2002', '张四', '参加项目招标', '2', '2016-11-16', '2016-11-16', '北京', 'train', '234.30', '345.30', '0', '100');
INSERT INTO `application` VALUES ('2', '2001', '张四', '项目交付', '1', '2016-11-21', '2016-11-29', '南京', '飞机', '300.00', '300.00', '0', '20');
INSERT INTO `application` VALUES ('3', '1001', '张五', '项目启动', '1', '2016-11-20', '2016-11-29', '上海', '动车', '500.00', '500.00', '0', '30');
INSERT INTO `application` VALUES ('4', '1002', '王五', '技术支持', '2', '2016-11-21', '2016-11-24', '南京', '高铁', '500.00', '500.00', '0', '20');
INSERT INTO `application` VALUES ('5', '2001', '张四', '项目开发', '1', '2016-11-22', '2016-12-21', '广东', '飞机', '600.00', '600.00', '0', '30');
INSERT INTO `application` VALUES ('6', '2002', '王四', '项目立项会议', '2', '2016-10-06', '2016-11-24', '南京', '火车', '200.00', '100.00', '0', '-1');
INSERT INTO `application` VALUES ('7', '2002', '王四', '开会', '2', '2016-11-02', '2016-11-17', '北京', '高铁', '200.00', '200.00', '0', '20');
INSERT INTO `application` VALUES ('8', '2002', '王四', '业务支持', '2', '2016-11-24', '2016-11-30', '上海', '高铁', '300.00', '300.00', '0', '-1');
INSERT INTO `application` VALUES ('9', '2002', '王四', '开会', '2', '2016-11-24', '2016-11-25', '北京', '飞机', '2000.00', '2000.00', '0', '20');

-- ----------------------------
-- Table structure for approval_authority
-- ----------------------------
DROP TABLE IF EXISTS `approval_authority`;
CREATE TABLE `approval_authority` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '权限表id',
  `user_id` int(10) NOT NULL COMMENT '审批者id',
  `user_name` varchar(20) NOT NULL COMMENT '审批者姓名',
  `user_role_id` int(10) NOT NULL COMMENT '审批者角色',
  `approval_order` int(4) NOT NULL COMMENT '审批顺序',
  `approval_state` int(4) NOT NULL COMMENT '审批状态码——10：部门经理，20：财务经理，30：行政经理',
  `deleted_mark` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approval_authority
-- ----------------------------
INSERT INTO `approval_authority` VALUES ('1', '1', '张五', '2', '2', '20', '0');
INSERT INTO `approval_authority` VALUES ('2', '2', '王五', '2', '1', '10', '0');
INSERT INTO `approval_authority` VALUES ('3', '3', '李五', '2', '1', '10', '0');
INSERT INTO `approval_authority` VALUES ('4', '4', '赵五', '2', '1', '10', '0');
INSERT INTO `approval_authority` VALUES ('5', '5', '刘五', '2', '1', '10', '0');
INSERT INTO `approval_authority` VALUES ('6', '15', '张飞', '2', '3', '30', '0');
INSERT INTO `approval_authority` VALUES ('7', '12', '朱三', '2', '3', '40', '0');

-- ----------------------------
-- Table structure for audit_log
-- ----------------------------
DROP TABLE IF EXISTS `audit_log`;
CREATE TABLE `audit_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `application_id` int(10) NOT NULL COMMENT '申请单id',
  `user_id` int(10) NOT NULL COMMENT '操作人id',
  `user_name` varchar(30) NOT NULL COMMENT '操作人id',
  `audit_date` datetime NOT NULL,
  `audit_type` int(2) NOT NULL COMMENT '1：提交申请，2：审批',
  `audit_result` int(2) DEFAULT NULL COMMENT '1：审批通过，2：审批未通过',
  `audit_feedback` varchar(300) DEFAULT NULL COMMENT '操作反馈信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audit_log
-- ----------------------------
INSERT INTO `audit_log` VALUES ('1', '1', '6', '张四', '2016-11-17 00:00:00', '1', '1', '测试');
INSERT INTO `audit_log` VALUES ('5', '1', '2', '王五', '2016-11-21 11:23:04', '2', '1', null);
INSERT INTO `audit_log` VALUES ('14', '2', '6', '张四', '2016-11-21 15:41:13', '1', null, null);
INSERT INTO `audit_log` VALUES ('15', '3', '1', '张五', '2016-11-21 15:53:01', '1', null, null);
INSERT INTO `audit_log` VALUES ('16', '4', '2', '王五', '2016-11-21 17:16:58', '1', null, null);
INSERT INTO `audit_log` VALUES ('17', '5', '6', '张四', '2016-11-21 17:27:06', '1', null, null);
INSERT INTO `audit_log` VALUES ('18', '6', '7', '王四', '2016-11-21 21:23:43', '1', null, null);
INSERT INTO `audit_log` VALUES ('19', '6', '2', '王五', '2016-11-21 21:46:04', '2', '1', null);
INSERT INTO `audit_log` VALUES ('20', '6', '1', '张五', '2016-11-22 09:36:14', '2', '2', '钱太多');
INSERT INTO `audit_log` VALUES ('21', '7', '7', '王四', '2016-11-22 11:41:43', '1', null, null);
INSERT INTO `audit_log` VALUES ('22', '7', '2', '王五', '2016-11-22 11:42:26', '2', '1', null);
INSERT INTO `audit_log` VALUES ('23', '5', '1', '张五', '2016-11-23 20:46:08', '2', '1', null);
INSERT INTO `audit_log` VALUES ('24', '8', '7', '王四', '2016-11-24 10:10:12', '1', null, '提交成功');
INSERT INTO `audit_log` VALUES ('25', '8', '2', '王五', '2016-11-24 10:14:33', '2', '2', '钱太多');
INSERT INTO `audit_log` VALUES ('26', '9', '7', '王四', '2016-11-24 11:21:45', '1', null, '提交成功');
INSERT INTO `audit_log` VALUES ('27', '6', '7', '王四', '2016-11-24 11:23:18', '1', null, '修改成功!');
INSERT INTO `audit_log` VALUES ('28', '9', '2', '王五', '2016-11-24 11:24:56', '2', '1', null);
INSERT INTO `audit_log` VALUES ('29', '6', '2', '王五', '2016-11-24 11:25:12', '2', '2', '钱太多');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(30) NOT NULL,
  `responsible_person_id` int(11) NOT NULL COMMENT '负责人id',
  `deleted_mark` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标志——0:正常 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '财务部', '1', '0');
INSERT INTO `department` VALUES ('2', 'IT互联网部', '2', '0');
INSERT INTO `department` VALUES ('3', '移动开发部', '3', '0');
INSERT INTO `department` VALUES ('4', '市场开发部', '4', '0');
INSERT INTO `department` VALUES ('5', '安全生产部', '5', '0');
INSERT INTO `department` VALUES ('6', '综合管理部', '12', '0');
INSERT INTO `department` VALUES ('7', '行政部', '15', '0');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_num` int(10) NOT NULL COMMENT '员工工号',
  `password` varchar(40) NOT NULL,
  `employee_name` varchar(30) NOT NULL,
  `dept_id` int(10) NOT NULL COMMENT '部门id',
  `role_id` int(10) NOT NULL COMMENT '角色ID',
  `is_delete` int(2) DEFAULT '0' COMMENT '员工是否在职。0：在职。1：离职',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '1001', 'e10adc3949ba59abbe56e057f20f883e', '张五', '1', '2', '0');
INSERT INTO `employee` VALUES ('2', '1002', 'e10adc3949ba59abbe56e057f20f883e', '王五', '2', '2', '0');
INSERT INTO `employee` VALUES ('3', '1003', 'e10adc3949ba59abbe56e057f20f883e', '李五', '3', '2', '0');
INSERT INTO `employee` VALUES ('4', '1004', 'e10adc3949ba59abbe56e057f20f883e', '赵五', '4', '2', '0');
INSERT INTO `employee` VALUES ('5', '1005', 'e10adc3949ba59abbe56e057f20f883e', '刘五', '5', '2', '0');
INSERT INTO `employee` VALUES ('6', '2001', 'e10adc3949ba59abbe56e057f20f883e', '张四', '1', '1', '0');
INSERT INTO `employee` VALUES ('7', '2002', 'e10adc3949ba59abbe56e057f20f883e', '王四', '2', '1', '0');
INSERT INTO `employee` VALUES ('8', '2003', 'e10adc3949ba59abbe56e057f20f883e', '李四', '3', '1', '0');
INSERT INTO `employee` VALUES ('9', '2004', 'e10adc3949ba59abbe56e057f20f883e', '赵元宝', '4', '1', '0');
INSERT INTO `employee` VALUES ('10', '2005', 'e10adc3949ba59abbe56e057f20f883e', '刘四', '5', '1', '0');
INSERT INTO `employee` VALUES ('11', '2006', 'e10adc3949ba59abbe56e057f20f883e', '删除', '5', '1', '1');
INSERT INTO `employee` VALUES ('12', '1006', 'e10adc3949ba59abbe56e057f20f883e', '朱三', '6', '2', '0');
INSERT INTO `employee` VALUES ('13', '1000', 'e10adc3949ba59abbe56e057f20f883e', '管理员', '6', '3', '0');
INSERT INTO `employee` VALUES ('14', '2007', 'e10adc3949ba59abbe56e057f20f883e', '张崇羿', '2', '1', '1');
INSERT INTO `employee` VALUES ('15', '1007', 'e10adc3949ba59abbe56e057f20f883e', '张飞', '7', '2', '0');
INSERT INTO `employee` VALUES ('16', '2008', 'e10adc3949ba59abbe56e057f20f883e', '张崇羿', '6', '1', '0');
INSERT INTO `employee` VALUES ('17', '2008', 'e10adc3949ba59abbe56e057f20f883e', 'yuan', '1', '1', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) NOT NULL COMMENT '角色名',
  `role_num` int(2) NOT NULL DEFAULT '0' COMMENT '角色编号，0：普通员工，10：经理，100：管理员',
  `role_desc` varchar(50) DEFAULT NULL COMMENT '角色描述',
  `deleted_mark` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通员工', '0', '公司内的普通员工', '0');
INSERT INTO `role` VALUES ('2', '经理', '10', '公司内经理级别的员工', '0');
INSERT INTO `role` VALUES ('3', '管理员', '100', '设置的管理员', '0');
