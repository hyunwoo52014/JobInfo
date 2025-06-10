-- 정렬 라벨
MERGE INTO SortLabel(abbreviation, label) VALUES
('df','최근 계시일 순(기본값)'),
('pd','최근 게시일 순'),
('pa','게시일순'),
('ud','최근수정일순'),
('ua','수정일순'),
('da','마감일순'),
('dd','마감일순(역순)'),
('rc','조회수순'),
('ac','지원자수');