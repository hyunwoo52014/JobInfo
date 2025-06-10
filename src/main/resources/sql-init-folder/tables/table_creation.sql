-- 테이블 선언
-- 근무형태/학력/연봉 코드
CREATE TABLE IF NOT EXISTS JobType (
	code INT PRIMARY KEY,
	label VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Education (
	code INT PRIMARY KEY,
	label VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Salary (
	code INT PRIMARY KEY,
	label VARCHAR(50)
);

-- 근무지/지역 코드표

CREATE TABLE IF NOT EXISTS LocationCodeFirst(
	code INT PRIMARY KEY,
	label VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS LocationCodeSeconds(
	code INT PRIMARY KEY,
	label VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS LocationCodeTotal (
	code INT PRIMARY KEY,
	label VARCHAR(50),
	code_seconds INT,
	code_first INT,
	CONSTRAINT fk_location_seconds
		FOREIGN KEY (code_seconds) REFERENCES LocationCodeSeconds(code),
	CONSTRAINT fk_location_first 
		FOREIGN KEY (code_first) REFERENCES LocationCodeFirst(code)
);

-- 산업/업종 코드표

CREATE TABLE IF NOT EXISTS IndustryRootCode(
	code INT PRIMARY KEY,
	label VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS IndustryCode (
	code INT PRIMARY KEY,
	label VARCHAR(50),
	root_code INT,
	FOREIGN KEY (root_code)
	REFERENCES IndustryRootCode(code) ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS BusinessCode (
	code INT PRIMARY KEY,
	label VARCHAR(50),
	industry_code INT,
	FOREIGN KEY (industry_code)
	REFERENCES IndustryCode(code) ON UPDATE CASCADE
);

-- 직무/직업 코드표

CREATE TABLE IF NOT EXISTS OccupationCode (
	code INT PRIMARY KEY,
	label VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS JobCode (
	code INT PRIMARY KEY,
	label VARCHAR(50),
	root_code INT,
	FOREIGN KEY (root_code)
	REFERENCES OccupationCode(code) ON UPDATE CASCADE
);


-- API관련 데이터
CREATE TABLE IF NOT EXISTS ApiTable (
	orderValue INT PRIMARY KEY,
	apiKey VARCHAR(100),
	headerValue VARCHAR(50)
);

-- 정렬 라벨
CREATE TABLE IF NOT EXISTS SortLabel (
	abbreviation VARCHAR(2) PRIMARY KEY,
	label VARCHAR(50)
);
