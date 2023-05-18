
CREATE DATABASE PRJ301_PGNB
GO
drop database PRJ301_PGNB

USE PRJ301_PGNB
CREATE TABLE [User](
	userID			NVARCHAR(6)		PRIMARY KEY,
	username		NVARCHAR(30)	NOT NULL, --Full name
	dob				DATE			NOT NULL,
	phone			NVARCHAR(11)	NOT NUll,
	[address]		NVARCHAR(50)	NOT NULL,
	email			NVARCHAR(30)	NOT NULL,
	[password]		NVARCHAR(20)	NOT NULL,
	[weight]		FLOAT			NOT NULL,
	height			FLOAT			NOT NULL,
	gender			INT				NOT NULL, --Male =1; Female = 0	
	activity		INT				NOT NULL, --Sedenatry = 1, lightly active = 2, moderately active = 3, active = 4, very active = 5
	preference		INT				NOT NULL, --No preference = 0, Asian and Pacific = 1, European and North America = 2, Mediterranean & Hispanic = 3, Vegan = 4
	goal			INT				NOT NULL, --Stay = 0, gain = 1, lose = -1
	amount			FLOAT			NOT NULL, --Default = 2kg
	duration		INT				NOT NULL, --Default = 8 weeks	
	main			INT				NOT NULL, --Default = 3
	side			INT				NOT NULL, --Default = 1
	[session]		INT				NOT NULL, --Default = 1
	[rank]			INT				NOT NULL, --Normal = 1, VIP = 2
	createdate		DATE			NOT NULL,

	--userID format: U*****
	CHECK (userID LIKE 'U[0-9][0-9][0-9][0-9][0-9]')
)

CREATE TABLE Exercise(
	exerciseID		NVARCHAR(5)		PRIMARY KEY,
	exname			NVARCHAR(60)	NOT NULL,
	lowerweight		FLOAT			NOT NULL,
	upperweight		FLOAT			NOT NULL,
	calorexp		INT				NOT NULL,
	icon			NVARCHAR(100)	NOT NULL,
	[description]	NVARCHAR(900)	NULL,

	--exerciseID format: EX***
	CHECK (exerciseID LIKE 'EX[0-9][0-9][0-9]')
)

CREATE TABLE Food(
	foodID			NVARCHAR(7)		PRIMARY KEY,
	foodname		NVARCHAR(30)	NOT NULL,
	category		NVARCHAR(20)	NOT NULL,
	size			INT				NOT NULL,
	caloricintake	INT				NOT NULL,
	carbohydrate	FLOAT			NOT NULL,
	fiber			FLOAT			NOT NULL,
	protein			FLOAT			NOT NULL,
	fat				FLOAT			NOT NULL,
	water			FLOAT			NOT NULL,
	icon			NVARCHAR(100)	NOT NULL,
	[description]	NVARCHAR(900)	NULL,

	--foodID format: FD*****
	CHECK (foodID LIKE 'FD[0-9][0-9][0-9][0-9][0-9]')
)

CREATE TABLE Product(
	productID		NVARCHAR(7)		PRIMARY KEY,
	productname		NVARCHAR(200)	NOT NULL,
	[type]			NVARCHAR(20)	NOT NULL,
	price			FLOAT			NOT NULL,
	quantity		INT				NOT NULL,
	brand			NVARCHAR(30)	NOT NULL,
	origin			NVARCHAR(20)	NOT NULL,
	volume			FLOAT			NULL,
	effect			NVARCHAR(500)	NULL,
	rate			FLOAT			NULL, --Default:4.0
	purchase		FLOAT			NULL, --Default: 100

	--productID format: PRO****
	CHECK (productID LIKE 'PRO[0-9][0-9][0-9][0-9]')
)

CREATE TABLE [Type](
	foodID			NVARCHAR(7)		FOREIGN KEY REFERENCES Food(foodID),
	[type]			INT				NOT NULL,
	PRIMARY KEY(foodID, [type])
)

CREATE TABLE FoodAvoidance(
	userID			NVARCHAR(6)		FOREIGN KEY REFERENCES [User](userID),
	foodID			NVARCHAR(7)		FOREIGN KEY REFERENCES Food(foodID),
	PRIMARY KEY(userID, foodID)
)

CREATE TABLE [Day](
	dayID			NVARCHAR(8)		PRIMARY KEY,
	userID			NVARCHAR(6)		FOREIGN KEY REFERENCES [User](userID),
	[index]			INT				NOT NULL,
	
	totalCalstd		FLOAT			NOT NULL, --Standard Calories Intake
	carbohydratestd	FLOAT			NOT NULL, --Standard Carbohydrate Intake
	fiberstd		FLOAT			NOT NULL, --Standard Fiber Intake
	proteinstd 		FLOAT			NOT NULL, --Standard Protein Intake
	fatstd			FLOAT			NOT NULL, --Standard Fat Intake
	waterstd		FLOAT			NOT NULL, --Standard Water Intake
	
	totalCal		FLOAT			NOT NULL, --Real Calories Intake
	carbohydrate	FLOAT			NOT NULL, --Real Carbohydrate Intake
	fiber			FLOAT			NOT NULL, --Real Fiber Intake
	protein 		FLOAT			NOT NULL, --Real Protein Intake
	fat				FLOAT			NOT NULL, --Real Fat Intake
	water			FLOAT			NOT NULL, --Real Water Intake

	-- dayID format: DAY*****
	CHECK (dayID LIKE 'DAY[0-9][0-9][0-9][0-9][0-9]')
)

CREATE TABLE ExSession(
	sessionID		NVARCHAR(9)		PRIMARY KEY,
	exerciseID		NVARCHAR(5)		FOREIGN KEY REFERENCES Exercise(exerciseID),
	userID			NVARCHAR(6)		FOREIGN KEY REFERENCES [User](userID),
	dayID			NVARCHAR(8)		FOREIGN KEY REFERENCES [Day](dayID),
	icon			NVARCHAR(100)	NOT NULL,

	-- sessionID format: SES******
	CHECK (sessionID LIKE 'SES[0-9][0-9][0-9][0-9][0-9][0-9]')
)

CREATE TABLE Meal(
	mealID			NVARCHAR(10)	PRIMARY KEY,
	userID			NVARCHAR(6)		FOREIGN KEY REFERENCES [User](userID),
	dayID			NVARCHAR(8)		FOREIGN KEY REFERENCES [Day](dayID),
	mealindex		INT				NOT NULL, --Breakfast = 1, Lunch = 2, Dinner = 3, Brunch = 4, Snack = 5
	
	totalCalstd		FLOAT			NOT NULL, --Standard Calories Intake
	carbohydratestd	FLOAT			NOT NULL, --Standard Carbohydrate Intake
	fiberstd		FLOAT			NOT NULL, --Standard Fiber Intake
	proteinstd 		FLOAT			NOT NULL, --Standard Protein Intake
	fatstd			FLOAT			NOT NULL, --Standard Fat Intake
	waterstd		FLOAT			NOT NULL, --Standard Water Intake
	
	totalCal		FLOAT			NOT NULL, --Real Calories Intake
	carbohydrate	FLOAT			NOT NULL, --Real Carbohydrate Intake
	fiber			FLOAT			NOT NULL, --Real Fiber Intake
	protein 		FLOAT			NOT NULL, --Real Protein Intake
	fat				FLOAT			NOT NULL, --Real Fat Intake
	water			FLOAT			NOT NULL, --Real Water Intake
	-- mealID format: MEAL******
	CHECK (mealID LIKE 'MEAL[0-9][0-9][0-9][0-9][0-9][0-9]')
)

CREATE TABLE FoodDetail(
	foodID			NVARCHAR(7)		FOREIGN KEY REFERENCES Food(foodID),
	mealID			NVARCHAR(10)		FOREIGN KEY REFERENCES Meal(mealID),
	amount			FLOAT			NOT NULL, -- in grams
	totalCal		FLOAT			NOT NULL, --Real Calories Intake
	carbohydrate	FLOAT			NOT NULL, --Real Carbohydrate Intake
	fiber			FLOAT			NOT NULL, --Real Fiber Intake
	protein 		FLOAT			NOT NULL, --Real Protein Intake
	fat				FLOAT			NOT NULL, --Real Fat Intake
	water			FLOAT			NOT NULL, --Real Water Intake
	icon			NVARCHAR(100)	NOT NULL,
	category		NVARCHAR(100)	NOT NULL,

	PRIMARY KEY(foodID, mealID)

)

CREATE TABLE Bill(
	billID			NVARCHAR(10)	PRIMARY KEY,
	userID			NVARCHAR(6)		FOREIGN KEY REFERENCES [User](userID),
	[date]			DATE			NOT NULL,
	delivery		NVARCHAR(15)	NULL, --Default: truck
	payment			NVARCHAR(15)	NULL, --Default: COD

	-- billID format: BILL******
	CHECK (billID LIKE 'BILL[0-9][0-9][0-9][0-9][0-9][0-9]')
)

CREATE TABLE ProductDetail(
	detailID		NVARCHAR(10)		PRIMARY KEY,
	productID		NVARCHAR(7)		FOREIGN KEY REFERENCES Product(productID),
	userID			NVARCHAR(6)		FOREIGN KEY REFERENCES [User](userID),
	billID			NVARCHAR(10)	FOREIGN KEY REFERENCES Bill(billID), --Default = 0: in the cart but not yet purchased
	quantity		INT				NOT NULL,

	-- detailID format: PD********
	CHECK (detailID LIKE 'PD[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')
)

CREATE TABLE SaleOff(
	saleoffID		NVARCHAR(7)		PRIMARY KEY,
	[description]	NVARCHAR(150)	NULL,
	startdate		DATE			NULL,
	enddate			DATE			NULL,
	[target]		INT				NULL, --Default:0

	--saleoffID format: SALE***
	CHECK (saleoffID LIKE 'SALE[0-9][0-9][0-9]')
)

CREATE TABLE PopUp(
	popupID			NVARCHAR(6)		PRIMARY KEY,
	[description]	NVARCHAR(150)	NULL,
	[status]		INT				NULL, --Default: 0; off: 0, on: 1
	theme			NVARCHAR(100)	NULL,  --URL

	--popupID format: POP***
	CHECK (popupID LIKE 'POP[0-9][0-9][0-9]')
)

CREATE TABLE SaleOffDetail(
	detailID		NVARCHAR(5)		PRIMARY KEY,
	saleoffID		NVARCHAR(7)		FOREIGN KEY REFERENCES SaleOff(saleoffID),
	productID		NVARCHAR(7)		FOREIGN KEY REFERENCES Product(productID),
	percentoff		INT				NULL,
	priceoff		FLOAT			NULL,
	gift			NVARCHAR(7)		NULL FOREIGN KEY REFERENCES Product(productID) --a sample product that represents not gift
)

CREATE TABLE PopUpDetail(
	popupID			NVARCHAR(6)		FOREIGN KEY REFERENCES PopUp(popupID),
	productID		NVARCHAR(7)		FOREIGN KEY REFERENCES Product(productID),
	[description]	NVARCHAR(50)	NULL,
	
	PRIMARY KEY(popupID, productID)
)

CREATE TABLE Comment(
	commentID		NVARCHAR(9)		PRIMARY KEY,
	userID			NVARCHAR(6)		FOREIGN KEY REFERENCES [User](userID),
	productID		NVARCHAR(7)		FOREIGN KEY REFERENCES Product(productID),
	rate			FLOAT			NOT NULL,
	content			NVARCHAR(500)	NULL,

	-- commentID format: CMT******
	CHECK (commentID LIKE 'CMT[0-9][0-9][0-9][0-9][0-9][0-9]')
)

CREATE TABLE [Image](
	imageID			NVARCHAR(9)		PRIMARY KEY,
	productID		NVARCHAR(7)		FOREIGN KEY REFERENCES Product(productID) NULL,
	foodID			NVARCHAR(7)		FOREIGN KEY REFERENCES Food(foodID) NULL,
	commentID		NVARCHAR(9)		FOREIGN KEY REFERENCES Comment(commentID) NULL,
	[url]			NVARCHAR(100)	NOT NULL,

	-- imageID format: IMG******
	CHECK (imageID LIKE 'IMG[0-9][0-9][0-9][0-9][0-9][0-9]')
)

SELECT foodID, mealID, amount FROM FoodDetail WHERE foodID = ? ORDER BY foodID ASC

INSERT INTO FoodDetail(foodID, mealID, amount) VALUES (?,?,?)

DELETE FROM Type WHERE foodID = '1' AND type = 1

SELECT mealID,userID,dayID,time,calosize FROM Meal WHERE dayID = 1

--INSERT TEST--
INSERT INTO [User] VALUES('U00000', 'dat', '2021-02-01', '123456789', 'hanoi', 'dat@gmail.com', '1234567', 65.4, 172, 1, 1, 0, 0, 2, 8, 3, 1, 1, 1, '2021-02-01')
INSERT INTO [Day] VALUES('DAY00000','U00000',0,0,0,0,0,0,0,0,0,0,0,0,0)
INSERT INTO [Meal] VALUES('MEAL000000','U00000','DAY00000',0,0,0,0,0,0,0,0,0,0,0,0,0)
INSERT INTO [Bill] VALUES('BILL000000','U00000','2021-02-01','123123123','123123123')
INSERT INTO [PopUp] VALUES('POP000','U00000',1,'123123123')

INSERT INTO Image VALUES('IMG000000', 'PRO0001', null, null, 'https://www.bootdey.com/image/250x220/FFB6C1/000000')
