-- SQL DDL for Hospital Research Project Management System

-- research_project table
CREATE TABLE `research_project` (
  `project_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Project ID',
  `project_name` VARCHAR(255) NOT NULL COMMENT 'Project Name',
  `principal_investigator_id` BIGINT NOT NULL COMMENT 'Principal Investigator ID (FK to system_users)',
  `department_id` BIGINT NOT NULL COMMENT 'Department ID (FK to system_dept)',
  `start_date` DATE NOT NULL COMMENT 'Start Date',
  `end_date` DATE NOT NULL COMMENT 'End Date',
  `total_funding_amount` DECIMAL(15,2) NOT NULL COMMENT 'Total Funding Amount',
  `project_status` VARCHAR(50) NOT NULL COMMENT 'Project Status (e.g., 申报中, 进行中, 已结题, 中止)',
  `project_description` TEXT NULL COMMENT 'Project Description',
  `creator` VARCHAR(64) NULL COMMENT 'Creator',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create Time',
  `updater` VARCHAR(64) NULL COMMENT 'Updater',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update Time',
  `deleted` BIT(1) NOT NULL DEFAULT 0 COMMENT 'Deleted flag',
  `tenant_id` BIGINT NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`project_id`),
  INDEX `idx_principal_investigator_id` (`principal_investigator_id`),
  INDEX `idx_department_id` (`department_id`),
  INDEX `idx_project_status` (`project_status`),
  INDEX `idx_start_date` (`start_date`),
  INDEX `idx_end_date` (`end_date`),
  CONSTRAINT `fk_project_principal_investigator` FOREIGN KEY (`principal_investigator_id`) REFERENCES `system_users` (`user_id`),
  CONSTRAINT `fk_project_department` FOREIGN KEY (`department_id`) REFERENCES `system_dept` (`dept_id`)
) COMMENT='Research Projects';

-- project_funding table
CREATE TABLE `project_funding` (
  `funding_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Funding ID',
  `project_id` BIGINT NOT NULL COMMENT 'Project ID (FK to research_project)',
  `budget_item_name` VARCHAR(255) NOT NULL COMMENT 'Budget Item Name',
  `budget_item_code` VARCHAR(100) NULL COMMENT 'Budget Item Code',
  `amount_planned` DECIMAL(15,2) NOT NULL COMMENT 'Amount Planned',
  `amount_received` DECIMAL(15,2) DEFAULT 0.00 COMMENT 'Amount Received',
  `amount_spent` DECIMAL(15,2) DEFAULT 0.00 COMMENT 'Amount Spent',
  `funding_source` VARCHAR(255) NULL COMMENT 'Funding Source',
  `received_date` DATE NULL COMMENT 'Received Date',
  `expenditure_date` DATE NULL COMMENT 'Expenditure Date',
  `voucher_number` VARCHAR(100) NULL COMMENT 'Voucher Number',
  `remarks` TEXT NULL COMMENT 'Remarks',
  `creator` VARCHAR(64) NULL COMMENT 'Creator',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create Time',
  `updater` VARCHAR(64) NULL COMMENT 'Updater',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update Time',
  `deleted` BIT(1) NOT NULL DEFAULT 0 COMMENT 'Deleted flag',
  `tenant_id` BIGINT NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`funding_id`),
  INDEX `idx_project_id_funding` (`project_id`),
  INDEX `idx_budget_item_name` (`budget_item_name`),
  CONSTRAINT `fk_funding_project` FOREIGN KEY (`project_id`) REFERENCES `research_project` (`project_id`)
) COMMENT='Project Funding Information';

-- research_achievement table
CREATE TABLE `research_achievement` (
  `achievement_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Achievement ID',
  `project_id` BIGINT NOT NULL COMMENT 'Project ID (FK to research_project)',
  `achievement_type` VARCHAR(100) NOT NULL COMMENT 'Achievement Type (e.g., 论文, 专利, 软件著作权, 奖励)',
  `achievement_name` VARCHAR(255) NOT NULL COMMENT 'Achievement Name',
  `publication_or_grant_date` DATE NULL COMMENT 'Publication or Grant Date',
  `intellectual_property_info` TEXT NULL COMMENT 'Intellectual Property Information',
  `authors_or_inventors` VARCHAR(500) NULL COMMENT 'Authors or Inventors',
  `journal_or_patent_office` VARCHAR(255) NULL COMMENT 'Journal or Patent Office',
  `status` VARCHAR(50) NOT NULL COMMENT 'Status (e.g., 已提交, 审核中, 已登记)',
  `creator` VARCHAR(64) NULL COMMENT 'Creator',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create Time',
  `updater` VARCHAR(64) NULL COMMENT 'Updater',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update Time',
  `deleted` BIT(1) NOT NULL DEFAULT 0 COMMENT 'Deleted flag',
  `tenant_id` BIGINT NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`achievement_id`),
  INDEX `idx_project_id_achievement` (`project_id`),
  INDEX `idx_achievement_type` (`achievement_type`),
  INDEX `idx_status_achievement` (`status`),
  CONSTRAINT `fk_achievement_project` FOREIGN KEY (`project_id`) REFERENCES `research_project` (`project_id`)
) COMMENT='Research Achievements';
