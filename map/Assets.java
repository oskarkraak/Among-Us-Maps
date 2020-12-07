package map;

import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

import java.io.StringWriter;
import java.io.PrintWriter;

public class Assets {
	
	// all rooms, tasks etc. in arrays are from left to right

	public static BufferedImage[] maps;
	public static BufferedImage[][] rooms;
	public static BufferedImage task;
	public static BufferedImage[][][] tasks;
	
	public static String[] mapNames = {"The Skeld", "Mira HQ", "Polus"};
	public static String[][] roomNames = {
			{"Reactor", "Upper Engine", "Lower Engine", "Security", "Med Bay", "Electrical", "Cafeteria", "Storage", "Admin", "Communication", "O2", "Weapons", "Shields", "Navigation"},
			{"Launchpad", "Reactor", "Laboratory", "Locker Room", "Hallway", "Communications", "Med Bay", "Greenhouse", "Office", "Admin", "Storage", "Balcony", "Cafeteria"},
			{"O2", "O2", "Boiler Room", "O2", "Security", "Electrical", "Electrical", "Outside", "Outside", "Outside", "Communications", "Weapons", "Outside", "Outside", "Dropship", "Storage", "Office", "Admin", "Office", "Outside", "Laboratory", "Outside", "Laboratory", "Laboratory", "Laboratory / Decontamination", "Specimen Room"},
	};
	public static String[][][] taskNames = { 
			//skeld
			{
				{"Unlock Manifolds", "Start Reactor", "Divert Power"}, //Reactor
		    	{"Align Engine Output", "Fuel Engines", "Accept Diverted Power"}, //Upper Engine
		    	{"Align Engine Output", "Fuel Engines", "Accept Diverted Power"}, //Lower Engine
		    	{"Fix Wiring", "Accept Diverted Power"}, //Security
		    	{"Submit Scan", "Inspect Sample"}, //Medbay
		    	{"Download / Upload Data", "Divert Power", "Fix Wiring", "Calibrate Distributor"}, //Electrical
		    	{"Fix Wiring", "Download / Upload Data", "Empty Chute / Garbage"}, //Cafeteria
		    	{"Fuel Engines", "Fix Wiring", "Empty Chute / Garbage"}, //Storage
		    	{"Fix Wiring", "Download / Upload Data", "Swipe Card"}, //Admin
		    	{"Download / Upload Data", "Accept Diverted Power"}, //Communication
		    	{"Empty Chute / Garbage", "Clean O2 Filter", "Accept Diverted Power"}, //O2
		    	{"Download / Upload Data", "Clear Asteroids","Accept Diverted Power"}, //Weapons
		    	{"Prime Shields", "Accept Diverted Power"}, //Shields
		    	{"Fix Wiring", "Divert Power", "Download / Upload Data", "Chart Course", "Stabilize Steering"}, //Navigation
			},
			//mirahq
			{
				{"Fuel Engines", "Accept Diverted Power", "Run Diagnostics"}, //Launchpad
		    	{"Unlock Manifolds", "Divert Power", "Start Reactor"}, //Reactor
		    	{"Fix Wiring", "Accept Diverted Power", "Assemble Artifact", "SortSamples"}, //Laboratory
		    	{"Fix Wiring"}, //Locker Room
		    	{"Fix Wiring"}, //Hallway
		    	{"Accept Diverted Power"}, //Communications
		    	{"Accept Diverted Power", "Submit Scan"}, //Medbay
		    	{"Accept Diverted Power", "Clean O2 Filter", "Fix Wiring", "Water Plants (2)"}, //Greenhouse
		    	{"Process Data", "Accept Diverted Power"}, //Office
		    	{"Enter ID Code", "Accept Diverted Power", "Prime Shields", "Chart Course"}, //Admin
		    	{"Water Plants (1)", "Fix Wiring"}, //Storage
		    	{"Clear Asteroids", "Measure Weather"}, //Balcony
		    	{"Accept Diverted Power", "Empty Chute / Garbage", "Buy Beverage"} //Cafeteria
			},
			//polus
			{
				{"Monitor Tree", "Download / Upload Data"}, //O2Tree
		    	{"Fill Canisters"}, //O2Water
		    	{"Replace Water Jug", "Open Waterways", "Open Waterways"}, //Boiler Room
		    	{"Empty Chute / Garbage", "Fix Wiring"}, //O2Hallway
		    	{}, //Security
		    	{"Fix Wiring", "Download / Upload Data"}, //Electrical Hallway
		    	{}, //Electrical Outside
		    	{"Fix Weather Nodes (1)"}, //Outside 1
		    	{"Fix Weather Nodes (1)"}, //Outside 2
		    	{"Fuel Engines"}, //Outside 3
		    	{"Reboot Wifi", "Download / Upload Data"}, //Communications
		    	{"Clear Asteroids", "Download / Upload Data"}, //Weapons
		    	{"Fix Weather Nodes (1)"}, //Outside 4
		    	{"Fix Weather Nodes (1)", "Open Waterways"}, //Outside 5
		    	{"Chart Course", "Insert Keys"}, //Dropship
		    	{"Fuel Engines"}, //Storage
		    	{"Fix Wiring", "Replace Water Jug"}, //Office Left
		    	{}, //Admin
		    	{"Swipe Card", "Scan Boarding Pass", "Download / Upload Data"}, //Office Right
		    	{"Fuel Engines", "Fix Weather Nodes (1)"}, //Outside 6
		    	{"Repair Drill"}, //Laboratory Outside
		    	{"Fix Weather Nodes (1)", "Record Temperature"}, //Outside 7
		    	{"Fix Weather Nodes (2)", "Record Temperature"}, //Laboratory Left
		    	{"Align Telescope", "Inspect Sample", "Submit Scan"}, //Laboratory Right
		    	{"Fix Wiring", "Fix Wiring", "Fix Wiring"}, //Laboratory Hallway
		    	{"Unlock Manifolds", "Start Reactor", "Store Artifacts", "Download / Upload Data"} //Specimen Room
			}
	};
	
	//layers: map - room - x/y
	public static int[][][][] roomCoordinates = {
			// The Skeld
		    { 
		    	{ {46, 84, 107, 107, 140, 140, 107, 107, 83, 46}, {213, 188, 188, 223, 223, 324, 324, 359, 359, 336} }, //Reactor
		    	{ {130, 158, 232, 232, 130}, {114, 90, 90, 202, 202} }, //Upper Engine
		    	{ {130, 232, 232, 158, 130}, {353, 353, 464, 464, 442} }, //Lower Engine
		    	{ {204, 236, 236, 258, 276, 293, 293, 236, 236, 204}, {254, 254, 230, 209, 209, 226, 323, 323, 297, 297} }, //Security
		    	{ {306, 398, 398, 435, 435, 326, 306}, {172, 172, 228, 265, 292, 292, 268} }, //Medbay
		    	{ {326, 435, 435, 409, 409, 386, 360, 360, 326}, {314, 314, 340, 368, 409, 431, 431, 445, 445} }, //Electrical
		    	{ {410, 454, 586, 649, 649, 594, 464, 410}, {69, 26, 26, 89, 210, 263, 263, 210} }, //Cafeteria
		    	{ {434, 467, 566, 566, 479, 434}, {374, 342, 342, 538, 538, 494} }, //Storage
		    	{ {548, 691, 691, 673, 583, 583, 548}, {290, 290, 368, 386, 386, 333, 333} }, //Admin
		    	{ {574, 682, 682, 658, 597, 574}, {455, 455, 515, 538, 538, 515} }, //Communication
		    	{ {662, 708, 708, 629, 629, 662}, {202, 202, 277, 277, 245, 209} }, //O2
		    	{ {691, 745, 790, 790, 714, 691}, {76, 76, 121, 187, 187, 165} }, //Weapons
		    	{ {691, 714, 790, 790, 743, 691}, {395, 371, 371, 438, 484, 484} }, //Shields
		    	{ {812, 870, 870, 912, 946, 946, 911, 871, 870, 812}, {239, 239, 210, 210, 241, 281, 310, 310, 281, 281} }, //Navigation
		    },
			// MiraHQ
			{
		    	{ {232, 333, 333, 232}, {426, 426, 506, 506} }, //Launchpad
		    	{ {360, 446, 446, 360}, {222, 222, 342, 342} }, //Reactor
		    	{ {446, 569, 569, 486, 486, 446}, {246, 246, 342, 342, 279, 279} }, //Laboratory
		    	{ {424, 503, 503, 553, 553, 424}, {460, 460, 403, 403, 508, 508} }, //Locker Room
		    	{ {554, 582, 593, 619, 593, 593, 554}, {364, 364, 353, 378, 404, 424, 424} }, //Hallway
		    	{ {593, 655, 655, 593}, {403, 403, 468, 468} }, //Communications
		    	{ {593, 655, 655, 593}, {469, 469, 547, 547} }, //Medbay
		    	{ {578, 753, 753, 686, 686, 646, 646, 578}, {66, 66, 134, 134, 151, 151, 134, 134} }, //Greenhouse
		    	{ {578, 645, 645, 578}, {135, 135, 222, 222} }, //Office
		    	{ {686, 753, 753, 686}, {135, 135, 222, 222} }, //Admin
		    	{ {667, 722, 722, 704, 704, 667}, {403, 403, 483, 483, 494, 494} }, //Storage
		    	{ {667, 861, 861, 710, 710, 667}, {519, 519, 555, 555, 574, 574} }, //Balcony
		    	{ {723, 861, 861, 723}, {403, 403, 505, 505} } //Cafeteria
		    } ,
			// Polus
			{ 
		    	{ {130, 205, 205, 130}, {358, 358, 426, 426} }, //O2Tree
		    	{ {130, 172, 172, 130}, {427, 427, 477, 477} }, //O2Water
		    	{ {130, 209, 209, 130}, {510, 510, 558, 558} }, //Boiler Room
		    	{ {172, 256, 256, 172}, {427, 427, 502, 502} }, //O2Hallway
		    	{ {155, 210, 210, 155}, {284, 284, 331, 331} }, //Security
		    	{ {155, 336, 336, 155}, {240, 240, 284, 284} }, //Electrical Hallway
		    	{ {249, 336, 336, 249}, {284, 284, 346, 346} }, //Electrical Outside
		    	{ {210, 307, 307, 210}, {502, 502, 575, 575} }, //Outside 1
		    	{ {246, 314, 314, 246}, {346, 346, 407, 407} }, //Outside 2
		    	{ {279, 400, 400, 279}, {202, 202, 239, 239} }, //Outside 3
		    	{ {314, 374, 374, 343, 343, 314}, {369, 369, 422, 422, 455, 455} }, //Communications
		    	{ {358, 387, 387, 394, 394, 370, 308, 308, 358}, {470, 470, 496, 496, 538, 562, 562, 496, 496} }, //Weapons
		    	{ {336, 448, 448, 460, 460, 420, 420, 374, 374, 336}, {284, 284, 308, 308, 379, 379, 405, 405, 368, 368} }, //Outside 4
		    	{ {394, 450, 450, 490, 490, 394}, {496, 496, 517, 517, 583, 583} }, //Outside 5
		    	{ {390, 484, 484, 390}, {73, 73, 212, 212} }, //Dropship
		    	{ {449, 551, 551, 472, 472, 449}, {278, 278, 333, 333, 307, 307} }, //Storage
		    	{ {419, 563, 563, 460, 460, 419}, {379, 379, 426, 426, 437, 437} }, //Office Left
		    	{ {490, 601, 601, 550, 550, 490}, {462, 462, 522, 522, 570, 570} }, //Admin
		    	{ {563, 662, 662, 563}, {379, 379, 426, 426} }, //Office Right
		    	{ {526, 590, 590, 526}, {213, 213, 278, 278} }, //Outside 6
		    	{ {590, 660, 660, 590}, {204, 204, 251, 251} }, //Laboratory Outside
		    	{ {604, 733, 733, 760, 760, 662, 662, 604}, {290, 290, 298, 298, 393, 393, 379, 379} }, //Outside 7
		    	{ {661, 733, 733, 661}, {204, 204, 251, 251} }, //Laboratory Left
		    	{ {733, 746, 778, 790, 790, 817, 817, 894, 894, 733}, {198, 186, 186, 198, 186, 186, 204, 204, 251, 251} }, //Laboratory Right
		    	{ {733, 894, 894, 733}, {251, 251, 298, 298} }, //Laboratory Hallway
		    	{ {753, 777, 836, 860, 860, 838, 778, 753}, {451, 427, 427, 450, 489, 511, 511, 486} } //Specimen Room
		    }
	};
	
	//because skeld has other sample values for mapX and mapY:
	public static int[] sampleMapX = { 5, 20, 20 };
	public static int[] sampleMapY = { 5, 43, 43 };
	
	public static int[][][][] taskCoordinates = {
			// The Skeld
		    { 
		    	{ {98, 160, 294}, {105, 335, 160} }, //Reactor
		    	{ {74, 177, 306}, {444, 418, 43} }, //Upper Engine
		    	{ {66, 166, 201}, {434, 415, 77} }, //Lower Engine
		    	{ {73, 493}, {295, 102} }, //Security
		    	{ {466, 618}, {490, 392} }, //Medbay
		    	{ {93, 180, 326, 545}, {46, 46, 88, 50} }, //Electrical
		    	{ {70, 586, 640}, {66, 85, 131} }, //Cafeteria
		    	{ {190, 251, 444}, {366, 25, 554} }, //Storage
		    	{ {224, 369, 778}, {67, 42, 308} }, //Admin
		    	{ {410, 758}, {54, 79} }, //Communication
		    	{ {171, 318, 765}, {242, 183, 130} }, //O2
		    	{ {230, 258, 542}, {42, 242, 247} }, //Weapons
		    	{ {138, 492}, {462, 50} }, //Shields
		    	{ {289, 488, 619, 774, 869}, {214, 37, 37, 131, 250} }, //Navigation
		    },
			// MiraHQ
			{ 
		    	{ {245, 258, 790}, {233, 423, 253} }, //Launchpad
		    	{ {276, 315, 510}, {254, 443, 332} }, //Reactor
		    	{ {213, 402, 622, 625}, {40, 48, 75, 462} }, //Laboratory
		    	{ {150}, {388} }, //Locker Room
		    	{ {448}, {110} }, //Hallway
		    	{ {297}, {52} }, //Communications
		    	{ {454, 641}, {38, 234} }, //Medbay
		    	{ {127, 456, 430, 770}, {386, 246, 543, 384} }, //Greenhouse
		    	{ {634, 683}, {43, 212} }, //Office
		    	{ {390, 438, 547, 680}, {323, 52, 466, 65} }, //Admin
		    	{ {535, 386}, {53, 570} }, //Storage
		    	{ {150, 961}, {218, 139} }, //Balcony
		    	{ {109, 535, 782}, {38, 30, 30} } //Cafeteria
		    },
			// Polus
			{ 
		    	{ {443, 614}, {207, 129} }, //O2Tree
		    	{ {466}, {211} }, //O2Water
		    	{ {254, 212, 807}, {110, 358, 356} }, //Boiler Room
		    	{ {570, 802}, {366, 90} }, //O2Hallway
		    	{ {}, {} }, //Security
		    	{ {186, 525}, {162, 162} }, //Electrical Hallway
		    	{ {}, {} }, //Electrical Outside
		    	{ {520}, {500} }, //Outside 1
		    	{ {536}, {333} }, //Outside 2
		    	{ {443}, {70} }, //Outside 3
		    	{ {414, 514}, {51, 38} }, //Communications
		    	{ {290, 778}, {236, 221} }, //Weapons
		    	{ {494}, {63} }, //Outside 4
		    	{ {318, 791}, {419, 198} }, //Outside 5
		    	{ {426, 598}, {133, 130} }, //Dropship
		    	{ {715}, {190} }, //Storage
		    	{ {109, 159}, {446, 111} }, //Office Left
		    	{ {}, {} }, //Admin
		    	{ {266, 420, 756}, {95, 62, 79} }, //Office Right
		    	{ {436, 577}, {40, 107} }, //Outside 6
		    	{ {692}, {190} }, //Laboratory Outside
		    	{ {654, 654}, {187, 445} }, //Outside 7
		    	{ {252, 630}, {114, 79} }, //Laboratory Left
		    	{ {185, 485, 915}, {90, 148, 317} }, //Laboratory Right
		    	{ {70, 568, 945}, {148, 142, 140} }, //Laboratory Hallway
		    	{ {209, 269, 514, 690}, {179, 71, 76, 44} } //Specimen Room
		    }
	};
	
	//sample coordinates and sizes of the rooms in RoomState
	public static int[][][] roomImageSamples = {
			// skeld
			{
				{3, 6, 5, 5, 7, 6, 6, 4, 6, 8, 8, 5, 6, 9}, //x
				{3, 6, 5, 5, 7, 6, 6, 4, 6, 8, 8, 5, 6, 9}, //y
				{387, 626, 594, 530, 714, 644, 671, 473, 984, 840, 858, 588, 625, 917}, //width
				{663, 663, 663, 663, 663, 663, 663, 663, 659, 663, 663, 663, 663, 663} //height
			},
			//mirahq
			{
				{175, 226, 57, 78, 69, 182, 255, 20, 247, 256, 325, 20, 32}, //x
				{16, 16, 16, 16, 16, 16, 16, 37, 16, 16, 16, 107, 16}, //y
				{673, 571, 909, 867, 885, 660, 513, 984, 530, 512, 374, 984, 959}, //width
				{663, 663, 663, 663, 663, 663, 663, 579, 663, 663, 663, 300, 663} //height
			},
			//polus
			{
				{217, 294, 20, 139, 119, 20, 126, 70, 70, 70, 253, 205, 70, 70, 179, 20, 20, 174, 20, 70, 216, 70, 130, 20, 20, 91}, //x
				{16, 16, 22, 16, 16, 94, 16, 16, 16, 16, 16, 16, 16, 16, 16, 27, 52, 16, 36, 16, 16, 16, 16, 50, 106, 16}, //y
				{589, 436, 984, 746, 785, 984, 771, 883, 883, 883, 518, 613, 883, 884, 666, 984, 984, 675, 984, 884, 592, 884, 764, 984, 984, 842}, //width
				{663, 663, 639, 663, 663, 352, 663, 663, 663, 663, 663, 663, 663, 663, 663, 619, 520, 663, 581, 663, 663, 663, 663, 526, 301, 663} //height
			}
	};
	
	public static void init() {
		System.out.println("Started initializing assets.");

		try {
			
			task = ImageTools.loadImage("/res/task.png");

			//load maps
			BufferedImage theSkeld = ImageTools.loadImage("/res/maps/skeld.png");
			BufferedImage polus = ImageTools.loadImage("/res/maps/polus.png");
			BufferedImage miraHQ = ImageTools.loadImage("/res/maps/mirahq.png");
			
			//assign maps to array
			BufferedImage[] m = {theSkeld, miraHQ, polus};
			maps = m;
			
			//load skeld rooms
			BufferedImage skeldAdmin = ImageTools.loadImage("/res/rooms/skeldAdmin.jpg");
			BufferedImage skeldCafeteria = ImageTools.loadImage("/res/rooms/skeldCafeteria.jpg");
			BufferedImage skeldCommunication = ImageTools.loadImage("/res/rooms/skeldCommunication.jpg");
			BufferedImage skeldElectrical = ImageTools.loadImage("/res/rooms/skeldElectrical.jpg");
			BufferedImage skeldLowerEngine = ImageTools.loadImage("/res/rooms/skeldLowerEngine.jpg");
			BufferedImage skeldMedbay = ImageTools.loadImage("/res/rooms/skeldMedbay.jpg");
			BufferedImage skeldNavigation = ImageTools.loadImage("/res/rooms/skeldNavigation.jpg");
			BufferedImage skeldO2 = ImageTools.loadImage("/res/rooms/skeldO2.jpg");
			BufferedImage skeldReactor = ImageTools.loadImage("/res/rooms/skeldReactor.jpg");
			BufferedImage skeldSecurity = ImageTools.loadImage("/res/rooms/skeldSecurity.jpg");
			BufferedImage skeldShields = ImageTools.loadImage("/res/rooms/skeldShields.jpg");
			BufferedImage skeldStorage = ImageTools.loadImage("/res/rooms/skeldStorage.jpg");
			BufferedImage skeldUpperEngine = ImageTools.loadImage("/res/rooms/skeldUpperEngine.jpg");
			BufferedImage skeldWeapons = ImageTools.loadImage("/res/rooms/skeldWeapons.jpg");
			
			//load mirahq rooms
			BufferedImage mirahqAdmin = ImageTools.loadImage("/res/rooms/mirahqAdmin.jpg");
			BufferedImage mirahqBalcony = ImageTools.loadImage("/res/rooms/mirahqBalcony.jpg");
			BufferedImage mirahqCafeteria = ImageTools.loadImage("/res/rooms/mirahqCafeteria.jpg");
			BufferedImage mirahqCommunications = ImageTools.loadImage("/res/rooms/mirahqCommunications.jpg");
			BufferedImage mirahqGreenhouse = ImageTools.loadImage("/res/rooms/mirahqGreenhouse.jpg");
			BufferedImage mirahqHallway = ImageTools.loadImage("/res/rooms/mirahqHallway.jpg");
			BufferedImage mirahqLaboratory = ImageTools.loadImage("/res/rooms/mirahqLaboratory.jpg");
			BufferedImage mirahqLaunchpad = ImageTools.loadImage("/res/rooms/mirahqLaunchpad.jpg");
			BufferedImage mirahqLockerRoom = ImageTools.loadImage("/res/rooms/mirahqLockerRoom.jpg");
			BufferedImage mirahqMedbay = ImageTools.loadImage("/res/rooms/mirahqMedbay.jpg");
			BufferedImage mirahqOffice = ImageTools.loadImage("/res/rooms/mirahqOffice.jpg");
			BufferedImage mirahqReactor = ImageTools.loadImage("/res/rooms/mirahqReactor.jpg");
			BufferedImage mirahqStorage = ImageTools.loadImage("/res/rooms/mirahqStorage.jpg");
			
			//load polus rooms
			BufferedImage polusAdmin = ImageTools.loadImage("/res/rooms/polusAdmin.jpg");
			BufferedImage polusBoilerRoom = ImageTools.loadImage("/res/rooms/polusBoilerRoom.jpg");
			BufferedImage polusCommunications = ImageTools.loadImage("/res/rooms/polusCommunications.jpg");
			BufferedImage polusDropship = ImageTools.loadImage("/res/rooms/polusDropship.jpg");
			BufferedImage polusElectricalHallway = ImageTools.loadImage("/res/rooms/polusElectricalHallway.jpg");
			BufferedImage polusElectricalOutside = ImageTools.loadImage("/res/rooms/polusElectricalOutside.jpg");
			BufferedImage polusLaboratoryHallway = ImageTools.loadImage("/res/rooms/polusLaboratoryHallway.jpg");
			BufferedImage polusLaboratoryLeft = ImageTools.loadImage("/res/rooms/polusLaboratoryLeft.jpg");
			BufferedImage polusLaboratoryOutside = ImageTools.loadImage("/res/rooms/polusLaboratoryOutside.jpg");
			BufferedImage polusLaboratoryRight = ImageTools.loadImage("/res/rooms/polusLaboratoryRight.jpg");
			BufferedImage polusO2Hallway = ImageTools.loadImage("/res/rooms/polusO2Hallway.jpg");
			BufferedImage polusO2Tree = ImageTools.loadImage("/res/rooms/polusO2Tree.jpg");
			BufferedImage polusO2Water = ImageTools.loadImage("/res/rooms/polusO2Water.jpg");
			BufferedImage polusOfficeLeft = ImageTools.loadImage("/res/rooms/polusOfficeLeft.jpg");
			BufferedImage polusOfficeRight = ImageTools.loadImage("/res/rooms/polusOfficeRight.jpg");
			BufferedImage polusOutside1 = ImageTools.loadImage("/res/rooms/polusOutside1.jpg");
			BufferedImage polusOutside2 = ImageTools.loadImage("/res/rooms/polusOutside2.jpg");
			BufferedImage polusOutside3 = ImageTools.loadImage("/res/rooms/polusOutside3.jpg");
			BufferedImage polusOutside4 = ImageTools.loadImage("/res/rooms/polusOutside4.jpg");
			BufferedImage polusOutside5 = ImageTools.loadImage("/res/rooms/polusOutside5.jpg");
			BufferedImage polusOutside6 = ImageTools.loadImage("/res/rooms/polusOutside6.jpg");
			BufferedImage polusOutside7 = ImageTools.loadImage("/res/rooms/polusOutside7.jpg");
			BufferedImage polusSecurity = ImageTools.loadImage("/res/rooms/polusSecurity.jpg");
			BufferedImage polusSpecimenRoom = ImageTools.loadImage("/res/rooms/polusSpecimenRoom.jpg");
			BufferedImage polusStorage = ImageTools.loadImage("/res/rooms/polusStorage.jpg");
			BufferedImage polusWeapons = ImageTools.loadImage("/res/rooms/polusWeapons.jpg");
			
			//assign rooms to array
			BufferedImage[][] r = { 
				//skeld
				{skeldReactor, skeldUpperEngine, skeldLowerEngine, skeldSecurity, skeldMedbay, skeldElectrical, skeldCafeteria, skeldStorage, skeldAdmin, skeldCommunication, skeldO2, skeldWeapons, skeldShields, skeldNavigation}, 
				//mirahq
				{mirahqLaunchpad, mirahqReactor, mirahqLaboratory, mirahqLockerRoom, mirahqHallway, mirahqCommunications, mirahqMedbay, mirahqGreenhouse, mirahqOffice, mirahqAdmin, mirahqStorage, mirahqBalcony, mirahqCafeteria},
				//polus
				{polusO2Tree, polusO2Water, polusBoilerRoom, polusO2Hallway, polusSecurity, polusElectricalHallway, polusElectricalOutside, polusOutside1, polusOutside2, polusOutside3, polusCommunications, polusWeapons, polusOutside4, polusOutside5, polusDropship,
				polusStorage, polusOfficeLeft, polusAdmin, polusOfficeRight, polusOutside6, polusLaboratoryOutside, polusOutside7, polusLaboratoryLeft, polusLaboratoryRight, polusLaboratoryHallway, polusSpecimenRoom}
			};
			rooms = r;
			
			//load tasks
			BufferedImage acceptDivertedPower = ImageTools.loadImage("/res/tasks/AcceptDivertedPower.jpg");
			BufferedImage alignEngineOutput = ImageTools.loadImage("/res/tasks/AlignEngineOutput.jpg");
			BufferedImage alignTelescope = ImageTools.loadImage("/res/tasks/AlignTelescope.jpg");
			BufferedImage assembleArtifact = ImageTools.loadImage("/res/tasks/AssembleArtifact.jpg");
			BufferedImage buyBeverage = ImageTools.loadImage("/res/tasks/BuyBeverage.jpg");
			BufferedImage calibrateDistributor = ImageTools.loadImage("/res/tasks/CalibrateDistributor.jpg");
			BufferedImage chartCourse = ImageTools.loadImage("/res/tasks/ChartCourse.jpg");
			BufferedImage cleanO2Filter = ImageTools.loadImage("/res/tasks/CleanO2Filter.jpg");
			BufferedImage clearAsteroids = ImageTools.loadImage("/res/tasks/ClearAsteroids.jpg");
			BufferedImage divertPower = ImageTools.loadImage("/res/tasks/DivertPower.jpg");
			BufferedImage downloadUploadData = ImageTools.loadImage("/res/tasks/DownloadUploadData.jpg");
			BufferedImage emptyChuteGarbage = ImageTools.loadImage("/res/tasks/EmptyChuteGarbage.jpg");
			BufferedImage enterIDCode = ImageTools.loadImage("/res/tasks/EnterIDCode.jpg");
			BufferedImage fillCanisters = ImageTools.loadImage("/res/tasks/FillCanisters.jpg");
			BufferedImage fixWeatherNodes1 = ImageTools.loadImage("/res/tasks/FixWeatherNodes1.jpg");
			BufferedImage fixWeatherNodes2 = ImageTools.loadImage("/res/tasks/FixWeatherNodes2.jpg");
			BufferedImage fixWiring = ImageTools.loadImage("/res/tasks/FixWiring.jpg");
			BufferedImage fuelEngines = ImageTools.loadImage("/res/tasks/FuelEngines.jpg");
			BufferedImage insertKeys = ImageTools.loadImage("/res/tasks/InsertKeys.jpg");
			BufferedImage inspectSample = ImageTools.loadImage("/res/tasks/InspectSample.jpg");
			BufferedImage measureWeather = ImageTools.loadImage("/res/tasks/MeasureWeather.jpg");
			BufferedImage monitorTree = ImageTools.loadImage("/res/tasks/MonitorTree.jpg");
			BufferedImage openWaterways = ImageTools.loadImage("/res/tasks/OpenWaterways.jpg");
			BufferedImage primeShields = ImageTools.loadImage("/res/tasks/PrimeShields.jpg");
			BufferedImage processData = ImageTools.loadImage("/res/tasks/ProcessData.jpg");
			BufferedImage rebootWifi = ImageTools.loadImage("/res/tasks/RebootWifi.jpg");
			BufferedImage recordTemperature = ImageTools.loadImage("/res/tasks/RecordTemperature.jpg");
			BufferedImage repairDrill = ImageTools.loadImage("/res/tasks/RepairDrill.jpg");
			BufferedImage replaceWaterJug = ImageTools.loadImage("/res/tasks/ReplaceWaterJug.jpg");
			BufferedImage runDiagnostics = ImageTools.loadImage("/res/tasks/RunDiagnostics.jpg");
			BufferedImage scanBoardingPass = ImageTools.loadImage("/res/tasks/ScanBoardingPass.jpg");
			BufferedImage sortSamples = ImageTools.loadImage("/res/tasks/SortSamples.jpg");
			BufferedImage stabilizeSteering = ImageTools.loadImage("/res/tasks/StabilizeSteering.jpg");
			BufferedImage startReactor = ImageTools.loadImage("/res/tasks/StartReactor.jpg");
			BufferedImage storeArtifacts = ImageTools.loadImage("/res/tasks/StoreArtifacts.jpg");
			BufferedImage submitScan = ImageTools.loadImage("/res/tasks/SubmitScan.jpg");
			BufferedImage swipeCard = ImageTools.loadImage("/res/tasks/SwipeCard.jpg");
			BufferedImage unlockManifolds = ImageTools.loadImage("/res/tasks/UnlockManifolds.jpg");
			BufferedImage waterPlants1 = ImageTools.loadImage("/res/tasks/WaterPlants1.jpg");
			BufferedImage waterPlants2 = ImageTools.loadImage("/res/tasks/WaterPlants2.jpg");
			
			//assign tasks to array
			BufferedImage[][][] t = { 
					//skeld
					{
						{unlockManifolds, startReactor, divertPower}, //Reactor
				    	{alignEngineOutput, fuelEngines, acceptDivertedPower}, //Upper Engine
				    	{alignEngineOutput, fuelEngines, acceptDivertedPower}, //Lower Engine
				    	{fixWiring, acceptDivertedPower}, //Security
				    	{submitScan, inspectSample}, //Medbay
				    	{downloadUploadData, divertPower, fixWiring, calibrateDistributor}, //Electrical
				    	{fixWiring, downloadUploadData, emptyChuteGarbage}, //Cafeteria
				    	{fuelEngines, fixWiring, emptyChuteGarbage}, //Storage
				    	{fixWiring, downloadUploadData, swipeCard}, //Admin
				    	{downloadUploadData, acceptDivertedPower}, //Communication
				    	{emptyChuteGarbage, cleanO2Filter, acceptDivertedPower}, //O2
				    	{downloadUploadData, clearAsteroids, acceptDivertedPower}, //Weapons
				    	{primeShields, acceptDivertedPower}, //Shields
				    	{fixWiring, divertPower, downloadUploadData, chartCourse, stabilizeSteering}, //Navigation
					},
					//mirahq
					{
						{fuelEngines, acceptDivertedPower, runDiagnostics}, //Launchpad
				    	{unlockManifolds, divertPower, startReactor}, //Reactor
				    	{fixWiring, acceptDivertedPower, assembleArtifact, sortSamples}, //Laboratory
				    	{fixWiring}, //Locker Room
				    	{fixWiring}, //Hallway
				    	{acceptDivertedPower}, //Communications
				    	{acceptDivertedPower, submitScan}, //Medbay
				    	{acceptDivertedPower, cleanO2Filter, fixWiring, waterPlants2}, //Greenhouse
				    	{processData, acceptDivertedPower}, //Office
				    	{enterIDCode, acceptDivertedPower, primeShields, chartCourse}, //Admin
				    	{waterPlants1, fixWiring}, //Storage
				    	{clearAsteroids, measureWeather}, //Balcony
				    	{acceptDivertedPower, emptyChuteGarbage, buyBeverage} //Cafeteria
					},
					//polus
					{
						{monitorTree, downloadUploadData}, //O2Tree
				    	{fillCanisters}, //O2Water
				    	{replaceWaterJug, openWaterways, openWaterways}, //Boiler Room
				    	{emptyChuteGarbage, fixWiring}, //O2Hallway
				    	{}, //Security
				    	{fixWiring, downloadUploadData}, //Electrical Hallway
				    	{}, //Electrical Outside
				    	{fixWeatherNodes1}, //Outside 1
				    	{fixWeatherNodes1}, //Outside 2
				    	{fuelEngines}, //Outside 3
				    	{rebootWifi, downloadUploadData}, //Communications
				    	{clearAsteroids, downloadUploadData}, //Weapons
				    	{fixWeatherNodes1}, //Outside 4
				    	{fixWeatherNodes1, openWaterways}, //Outside 5
				    	{chartCourse, insertKeys}, //Dropship
				    	{fuelEngines}, //Storage
				    	{fixWiring, replaceWaterJug}, //Office Left
				    	{}, //Admin
				    	{swipeCard, scanBoardingPass, downloadUploadData}, //Office Right
				    	{fuelEngines, fixWeatherNodes1}, //Outside 6
				    	{repairDrill}, //Laboratory Outside
				    	{fixWeatherNodes1, recordTemperature}, //Outside 7
				    	{fixWeatherNodes2, recordTemperature}, //Laboratory Left
				    	{alignTelescope, inspectSample, submitScan}, //Laboratory Right
				    	{fixWiring, fixWiring, fixWiring}, //Laboratory Hallway
				    	{unlockManifolds, startReactor, storeArtifacts, downloadUploadData} //Specimen Room
					}
			};
			tasks = t;

		} catch (Exception e) {
			System.out.println("An error occured loading the assets.");
//			String a = e.getMessage();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String a = sw.toString(); // stack trace as a string
			System.out.println(a);
			JOptionPane.showMessageDialog(null, a);
			System.exit(1);
		}

		System.out.println("Assets initialized.");
	}
}
