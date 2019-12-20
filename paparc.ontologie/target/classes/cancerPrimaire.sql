Drop table if exists CancerPrimaire;

Create table CancerPrimaire (
patient int(6),
topo_IACR varchar(7),
morpho_IACR varchar(7)
);

Insert Into CancerPrimaire VALUES
(864787,"52","13"),
(864787,"31","11"),
(527647,"20","16"),
(527647,"5","3"),
(329048,"29","9"),
(329048,"40","15"),
(384382,"1","12"),
(384382,"8","17"),
(837404,"41","5"),
(468647,"16","14"),
(103823,"22","8"),
(103823,"10","11"),
(103823,"34","5");