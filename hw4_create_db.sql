-- ----------------------------
--  Table structure for `User`
-- ----------------------------
DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `userID` int NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`userID`)
);

insert into User(
userID,
firstName,
lastName,
email,
`password`
)

values
('0', 'Christopher', 'Bare', 'christopherbare@outlook.com',
      '5E9DD8B43E30B80CB55CC34E774D42DC56849274CF60A9A35A4D4BA271EFAB74'),
('1', 'Noodlebob', 'Pantsman', '3mail@3mail.com', 
      '5E9DD8B43E30B80CB55CC34E774D42DC56849274CF60A9A35A4D4BA271EFAB74');


CREATE TABLE `Admin` (
  `userID` varchar(50) NOT NULL,
  
  PRIMARY KEY (`userID`)
);

insert into Admin(
userID
)

values
('0');

-- ----------------------------
--  Table structure for `Product`
-- ----------------------------
DROP TABLE IF EXISTS `Item`;

Create TABLE `Item` (
  `itemCode` varchar(50) NOT NULL DEFAULT '0',
  `name` varchar(50) DEFAULT NULL,
  `catelogCategory` varchar(50) DEFAULT NULL,
  `tagline` text DEFAULT NULL,
  `description` text DEFAULT NULL,
  `rating` float(50) DEFAULT NULL,
  `price` float(50) DEFAULT NULL,
  `numRatings` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`itemCode`)
);	

insert into Item(
itemCode,
`name`,
catelogCategory,
tagline,
description,
rating,
price,
numRatings
)

values("c33b", "3x3 Basic SpeedCube", "3x3", "The GAN 356 Air S Master is now available! This version is the non-magnetized version of the Air SM...", 
"<p>The GAN 356 Air S Master is now available! This version is the non-magnetized version of the Air SM with a design that prioritizes soft feel and light weight, 
a new and improved elasticity system (GES V2), and a unique honeycomb 
design on the pieces. The magnet slots that are present in the Air SM have been removed in the Air S in order to make the 
puzzle as light as possible, and the standard clear GES V2 nuts are pre-installed.</p> 
<p>The Air S feels very fast and quiet right out of the box. Each Air S 
comes with a set of G-Series GES V2 parts, GAN full bright stickers, a GAN CFOP tutorial pamphlet, and plastic adjusting tool.</p>", 3, 15.89, 0);
 
insert into Item(
itemCode,
`name`,
catelogCategory,
tagline,
description,
rating,
price,
numRatings
)
 
values("c33d", "3x3 Deluxe SpeedCube", "3x3", "The GAN 356 Air S Master is now available! This version is the non-magnetized version of the Air SM...", "<p>The GAN 356 Air 
S Master is now available! This version is the non-magnetized version of the Air 
SM with a design that prioritizes soft feel and light weight, a new and improved 
elasticity system (GES V2), and a unique honeycomb design on the pieces. The magnet 
slots that are present in the Air SM have been removed in the Air S in order to make the 
puzzle as light as possible, and the standard clear GES V2 nuts are pre-installed.</p>
<p>The Air S feels very fast and quiet right out of the box. Each Air S comes with a set of 
G-Series GES V2 parts, GAN full bright stickers, a GAN CFOP tutorial pamphlet, and plastic adjusting tool.</p>", 4, 20.20, 0);

insert into Item(
itemCode,
`name`,
catelogCategory,
tagline,
description,
rating,
price,
numRatings
)

values("c33p", "3x3 Performance SpeedCube", "3x3", "The GAN 356 Air S Master is now available! This version is the non-magnetized version of the Air SM...", "<p>The 
GAN 356 Air S Master is now available! This version is the non-magnetized version of the 
Air SM with a design that prioritizes soft feel and light weight, a new and improved elasticity 
system (GES V2), and a unique honeycomb design on the pieces. The magnet slots that are present 
in the Air SM have been removed in the Air S in order to make the puzzle as light as possible, 
and the standard clear GES V2 nuts are pre-installed.</p>
<p>The Air S feels very fast and quiet right out of the box. Each Air S comes with a set of 
G-Series GES V2 parts, GAN full bright stickers, a GAN CFOP tutorial pamphlet, and plastic adjusting tool.</p>", 5, 25.99, 0);
            
insert into Item(
itemCode,
`name`,
catelogCategory,
tagline,
description,
rating,
price,
numRatings
)

values("c44", "4x4 SpeedCube", "4x4", "The MoYu AoSu GTS M is the upgraded version of the iconic AoSu, which was first released at the beginning of 2014...", "<p>
The MoYu AoSu GTS M is the upgraded version of the iconic AoSu, which was first released 
at the beginning of 2014. It features superb corner-cutting, stability, and an overall 
improved feeling. Additionally, the AoSu GTS M is fully magnetized right out of the box 
to provide tactile feedback and outstanding turning.</p>
<p>The AoSu GTS M is packaged inside a large display box with a magnetic latch, and it
 includes a randomly-selected MoYu collectible card and a few spare magnets.</p>", 3, 30.94, 0);
            
insert into Item(
itemCode,
`name`,
catelogCategory,
tagline,
description,
rating,
price,
numRatings
)

values("c55", "5x5 SpeedCube", "5x5", "The latest and greatest 5x5 from MoYu 
is now available! With its new and improved design, the MoYu HuaChuang 5x5 is touted by 
MoYu themselves to be the best 5x5 on the market...", "<p>The latest and greatest 5x5 
from MoYu is now available! With its new and improved design, the MoYu HuaChuang 
5x5 is touted by MoYu themselves to be the best 5x5 on the market. It measures 
64mm across, and appears virtually identical to the MoYu AoChuang 5x5 in terms 
of size and shape on the outside. While it generally performs on a similar level 
to the MoYu AoChuang, it features some improvements in turning and stability 
that are likely to make it a refreshing upgrade for dedicated 5x5 speedcubers.</p>", 4, 35.98, 0);
            
insert into Item(
itemCode,
`name`,
catelogCategory,
tagline,
description,
rating,
price,
numRatings
)

values("c66", "6x6 SpeedCube", "6x6", "The QiYi WuHua 6x6 V2 is the 
updated version of the original WuHua 6x6, a high-performance 6x6 cube by QiYi MoFangGe. 
The changes in the WuHua 6x6 V2 are mainly focused on reinforcing...", 
"<p>The QiYi WuHua 6x6 V2 is the updated version of the original WuHua 6x6, a high-performance 6x6 cube by QiYi 
MoFangGe. The changes in the WuHua 6x6 V2 are mainly focused on reinforcing the more 
delicate pieces, like the corners, center pieces, and internal parts, to reduce breakage 
while improving the smoothness and overall performance of the original WuHua.</p>", 5, 45.87, 0);