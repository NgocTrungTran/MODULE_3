USE QuanLyKhoHang;
CREATE TABLE NhaCC(
cID			INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name		VARCHAR(50),
adress		VARCHAR(50),
phoneNum	INT
);
ALTER TABLE `quanlykhohang`.`nhacc` 
ADD UNIQUE INDEX `phoneNum_UNIQUE` (`phoneNum` ASC) VISIBLE;
ALTER TABLE nhacc
CHANGE COLUMN cID cID INT NOT NULL ;
CREATE TABLE VatTu(
vID			INT NOT NULL PRIMARY KEY,
vName		VARCHAR(30),
cID			INT NOT NULL,
FOREIGN KEY (cID) REFERENCES NhaCC(cID)
);
CREATE TABLE dondh(
DhID		INT NOT NULL PRIMARY KEY,
DateDh		DATETIME,
cID			INT NOT NULL,
FOREIGN KEY (cID) REFERENCES NhaCC(cID)
);
ALTER TABLE dondh 
CHANGE COLUMN DhID DhID INT NOT NULL AUTO_INCREMENT;
ALTER TABLE dondh
ADD COLUMN vID INT NOT NULL;
ALTER TABLE dondh
ADD FOREIGN KEY (vID) REFERENCES VatTu(vID);
CREATE TABLE PhieuNhap(
nID			INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nDate		DATETIME,
nDg			DOUBLE,
nSl			INT,
vID			INT NOT NULL,
FOREIGN KEY (vID) REFERENCES VatTu(vID)
);
CREATE TABLE PhieuXuat(
xID			INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
xDate		DATETIME,
xDg			DOUBLE,
xSl 		INT,
vID			INT NOT NULL,
FOREIGN KEY (vID) REFERENCES VatTu(vID)
);