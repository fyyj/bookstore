drop TABLE if exists notice;
CREATE TABLE `notice` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `n_time` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*ENGINE=Innodb 事务控制能力功能*/

insert  into `notice`(`n_id`,`title`,`details`,n_time) values (1,'斗破苍穹上线通知','<br>\r\n天蚕土豆良心制作，超人气小说','201803052003');
DROP TABLE if EXISTS orderitem;
CREATE TABLE `orderitem` (
  `order_id` varchar(100) NOT NULL DEFAULT '',
  `product_id` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`order_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists orders;
CREATE TABLE `orders` (
  `id` varchar(100) NOT NULL,
  `money` double DEFAULT NULL,
  `receiverAddress` varchar(255) DEFAULT NULL,
  `receiverName` varchar(20) DEFAULT NULL,
  `receiverPhone` varchar(20) DEFAULT NULL,
  `paystate` int(11) DEFAULT '0',
  `ordertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop TABLE if exists products;
CREATE TABLE `products` (
  `id` varchar(100) NOT NULL DEFAULT '',
  `name` varchar(40) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category` varchar(40) DEFAULT NULL,
  `pnum` int(11) DEFAULT NULL,
  `imgurl` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert  into `products`(`id`,`name`,`price`,`category`,`pnum`,`imgurl`,`description`) values 
('1','.net设计规范',50,'计算机',16,'/productImg/net.jpg','数千名微软精锐开发人员的经验和智慧，最终浓缩在这本设计规范之中。与上一版相比，书中新增了许多评注，解释了相应规范的背景和历史，从中你能聆听到微软技术大师Anders Hejlsberg、Jeffrey Richter和Paul Vick等的声音，读来令人兴味盎然。'),
('2','网管员必备宝典',20,'计算机',15,'/productImg/wangguan.jpg','计算机类'),
('3','学会宽容',25,'文学',5,'/productImg/xvehui.jpg','该书阐述了宽容是一种智慧和力量，是对生命的洞悉，是成长的绿荫，更是家庭幸福的秘诀。常用宽容的眼光看世界，事业、家庭和友谊才能稳固和长久。'),
('4','杜拉拉升职记',54,'原版',198,'/productImg/dulala.jpg','职场生活'),
('5','时空穿行',42,'科技',200,'/productImg/science.jpg','《时空穿行(中国乡村人类学世纪回访)》对20世纪80年代以来中国云南大理西镇、广东潮州凤凰村、华南茶山等八个代表性乡村田野进行调查，探讨了中国乡村文化的多样性、宗族制度、农民社会等课题。'),
('6','培育男孩',59,'社科',94,'/productImg/sheke.jpg','如何教育孩子'),
('7','Java基础入门',44.5,'计算机',7,'/productImg/java.png','《Java基础入门》从初学者的角度详细讲解了Java开发中重点用到的多种技术。全书共11章，包括Java开发环境的搭建及其运行机制、基本语法、面向对象的思想，采用典型翔实的例子、通俗易懂的语言阐述面向对象中的抽象概念。在多线程、常用API、集合、IO、GUI、网络编程章节中，通过剖析案例、分析代码结构含义、解决常见问题等方式，帮助初学者培养良好的编程习惯。最后，讲解了Eclipse开发工具，帮助初学者熟悉开发工具的使用。'),
('8','赢在影响力',89,'励志',47,'/productImg/win.jpg','《赢在影响力：人际交往的学问》创造了全球出版史上空前的发行记录。它深深地触动着读者的神经，满足了他们在人性方面的需要，因此成为经济萧条后期超越流行的读物。它居高不下的销售记录一直持续至20世纪80年代，经历了几乎半个世纪。'),
('9','大勇和小花的欧洲日记',26,'生活百科',100,'/productImg/dayong.jpg','《大勇和小花的欧洲日记》串起了欧洲文明的溯源之旅。从屹立在近现代艺术之巅的巴黎拾级而下，依次是蓬皮杜博物馆（现代艺术）、奥塞博物馆（印象派艺术）、卢浮宫博物馆（古典主义）。在这里，蒙娜丽莎向文艺复兴的故乡微笔，那是意大利的佛罗伦萨。达芬奇、米开朗琪罗、拉菲尔等巨匠们开创了文艺复兴运动，他们心中的圣地是希腊，似乎已到了起源。然而，这并未到头，与这源头对接的还有遥远的希腊神话，其中有大西洲的传说。在希腊小岛圣托里尼，你看见Atlantica酒店吗？那是人们为大西洲刻下的念想。'),
('10','Java Web程序开发入门',44.5,'计算机',100,'/productImg/web.png','本书为Java Web开发入门教材，让初学者达到能够灵活使用Java语言开发Web应用程序的程度。为了让初学者易于学习，本书力求内容通俗易懂，讲解寓教于乐，同时针对书中的每个知识点，都精心设计了经典案例，让初学者真正理解这些知识点在实际工作中如何去运用。'),
('11','谁动了我的奶酪',26,'少儿',200,'/productImg/nailao.jpg','儿童作品'),
('12','别做正常的傻瓜',18,'励志',2,'/productImg/shagua.png','本书结合了作者十余年的教学经验，融合了诺贝尔奖得主及其他学者数十年的研究成果，用深入浅出的方法帮助你发现自己决策中的误区，从而使你比大多数人少几分正常，多几分理性，本书所涉及的决策范围广，包括购买什么商品，和什么人结婚，雇用哪些员工，投资什么股票等等。除非你从不做决策，否则本书对你一定有所借鉴。'),
('13','培育男孩',25,'生活',8,'/productImg/boy.jpg','本书是美国著名家庭问题和儿童教育问题专家、畅销书作家詹姆士·杜布森的新作。全书围绕值得令人类关注的培育男孩问题，讨论了家庭教育、学校教育、父母关爱，以及整个社会文化对男孩成长的影响。针对美国社会普遍存在的男孩教育问题，如父亲缺席、母亲上班、暴力泛滥、单亲家庭、同性恋、学校对男孩特点的忽视等等，提出了自己的看法和解决思路，具有很强的指导性和可操作性，是父母、教师和青年工作者的必读参考书。'),
('14','travelbook',20,'外语',20,'/productImg/foreign.jpg',''),
('15','经济案例解析',35,'经营',98,'/productImg/demo.jpg',''),
('16','美国纽约摄影学院摄影教材',45,'艺术',99,'/productImg/art.jpg','艺术教材'),
('17','系统分析师教程',54,'考试',300,'/productImg/teach.jpg','系统分析师'),
('18','中国国家地理',20,'学术',20,'/productImg/dili.jpg','《中国国家地理》，原名《地理知识》，是关于地理的月刊，该刊的文章和图片经常被中央及地方媒体转载。具有很强的可读性和收藏价值，国内外很多家图书馆已经把该刊作为重点收藏期刊。内容以中国地理为主，兼具世界各地不同区域的自然、人文景观和事件，并揭示其背景和奥秘，另亦涉及天文、生物、历史和考古等领域。是中国大陆著名的有关地理的杂志。因该社隶属中国科学院，有一大批自然地理和人文地理的专家学者作为该社顾问，同时还有许多战斗在科考第一线的工作者与杂志社保持着密切联系，因此具有很强的独家性和权威性。');

DROP TABLE if exists user;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `introduce` varchar(100) DEFAULT NULL,
  `role` varchar(10) DEFAULT '普通用户',
  `registTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert  into user values (1,'admin','123456','男','huan9yun@163.com','13041019968','我是超级管理员，我可以登录后台管理系统','超级用户','2018-04-17 16:16:40');
INSERT into user values (2,'zhangsan','123456','女','huan9yun@163.com','13269219270','我是一个课程设计师','普通用户','2018-03-19 18:12:36');
INSERT into user values (3,'lisi','123456','男','huan9yun@163.com','13041019968','大家好，我是黄云','普通用户','2018-04-17 17:36:38');
INSERT into user values (4,'wangwu','123456','男','hym@163.com','15207545526','课程设计师','普通用户','2018-04-18 15:19:32');
