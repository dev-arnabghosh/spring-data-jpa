-- CREATE TABLE `bootdemo`.`employee` (
--     `eid` INT NOT NULL,
--     `ename` VARCHAR(20) NULL,
--     `esal` DOUBLE NULL,
--     `dept` VARCHAR(10) NULL,
--     PRIMARY KEY (`eid`)
-- );

INSERT INTO employee (eid, ename, esal, dept) VALUES
(10, 'ABC', 200, 'DE'),
(11, 'XYZ', 200, 'QA'),
(12, 'MNO', 200, 'BA'),
(13, 'PQR', 300, 'DEV'),
(14, 'GGH', 300, 'BA'),
(15, 'YHU', 300, 'QA'),
(16, 'UYH', 400, 'DEV'),
(17, 'RGS', 400, 'BA'),
(18, 'IJD', 400, 'QA');

SELECT 
    emp.eid, emp.ename, emp.dept, emp.esal
FROM
    employee AS emp
ORDER BY emp.esal desc;

-- after esal sort dept also - MULTI COL Sorting
SELECT 
    emp.eid, emp.ename, emp.esal, emp.dept
FROM
    employee AS emp
ORDER BY emp.esal DESC , emp.dept ASC;

SELECT 
    emp.dept, 
    AVG(emp.esal) as avg_sal
FROM
    employee AS emp
GROUP BY emp.dept
HAVING avg_sal > 300
ORDER BY avg_sal DESC;

desc employee;

-- delete from employee;


select * from employee;


select * from employee;

select * from employee limit 0,4;








