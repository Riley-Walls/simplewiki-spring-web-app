package ca.sheridancollege.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Article;
import ca.sheridancollege.beans.Section;

public class DAO {
	
	SessionFactory sessionFactory = new Configuration().configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();
	
	public DAO() {
		populate();
	}
	
	public void populate() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Article article;
		Section section;
		List<Section> sections;
		
		//ARTICLE 1
		
		article = new Article();
		article.setTitle("Hippopotamus");
		
		sections = new ArrayList<Section>();
		
		section = new Section();
		section.setTitle("Summary");
		section.setContent("The common hippopotamus (Hippopotamus amphibius), or hippo, is a large, mostly herbivorous, semiaquatic mammal native to sub-Saharan Africa. It is one of only two extant species in the family Hippopotamidae, the other being the pygmy hippopotamus (Choeropsis liberiensis or Hexaprotodon liberiensis). The name comes from the ancient Greek for \"river horse\". After the elephant and rhinoceros, the common hippopotamus is the third-largest type of land mammal and the heaviest extant artiodactyl. Despite their physical resemblance to pigs and other terrestrial even-toed ungulates, the closest living relatives of the Hippopotamidae are cetaceans (whales, dolphins, porpoises, etc.) from which they diverged about 55 million years ago.");
		sections.add(section);

		section = new Section();
		section.setTitle("Etymology");
		section.setContent("The Latin word 'hippopotamus' is derived from the ancient Greek, hippopotamos, from, hippos, 'horse', and, potamos, 'river', meaning 'horse of the river'. In English, the plural is 'hippopotamuses', but 'hippopotami' is also used; 'hippos' can be used as a short plural. Hippopotamuses are gregarious, living in groups of up to thirty animals. A group is called a pod, herd, dale, or bloat.");
		sections.add(section);
		
		section = new Section();
		section.setTitle("Taxonomy and Origins");
		section.setContent("The hippopotamus is the type genus of the family Hippopotamidae. The pygmy hippopotamus belongs to a different genus in Hippopotamidae, either Choeropsis or Hexaprotodon. Hippopotamidae are sometimes known as hippopotamids. Sometimes, the subfamily Hippopotaminae is used. Further, some taxonomists group hippopotamuses and anthracotheres in the superfamily Anthracotheroidea.[7]:39 Hippopotamidae are classified along with other even-toed ungulates in the order Artiodactyla. Other artiodactyls include camels, cattle, deer and pigs, although hippopotamuses are not closely related to these groups.");
		sections.add(section);
		
		article.setSections(sections);

		session.save(article);
		
		//ARTICLE 2
		
		article = new Article();
		article.setTitle("Coral Castle");
		
		sections = new ArrayList<Section>();
		
		section = new Section();
		section.setTitle("Summary");
		section.setContent("Coral Castle is an oolite limestone structure created by the Latvian-American eccentric Edward Leedskalnin (1887–1951). It is located in unincorporated territory of Miami-Dade County, Florida, between the cities of Homestead and Leisure City. The structure comprises numerous megalithic stones, mostly limestone formed from coral, each weighing several tons.[2] It is currently a privately operated tourist attraction. Coral Castle is noted for legends surrounding its creation that claim it was built single-handedly by Leedskalnin using reverse magnetism or supernatural abilities to move and carve numerous stones weighing many tons.[3][4]");
		sections.add(section);

		section = new Section();
		section.setTitle("History");
		section.setContent("Coral Castle's own promotional material says Edward Leedskalnin was suddenly rejected by his 16-year-old fiancée Agnes Skuvst in Latvia, just one day before the wedding. Leaving for America, he came down with allegedly terminal tuberculosis, but spontaneously healed, stating that magnets had some effect on his disease.\r\n" + 
				"\r\n" + 
				"Edward spent more than 28 years building Coral Castle, refusing to allow anyone to view him while he worked. A few teenagers claimed to have witnessed his work, reporting that he had caused the blocks of coral to move like hydrogen balloons. The only tool that Leedskalnin spoke of using was a \"perpetual motion holder\".\r\n" + 
				"\r\n" + 
				"Leedskalnin originally built a castle, which he named \"Ed's Place,\" in Florida City, Florida, around 1923. He purchased the land from Ruben Moser whose wife had assisted him when he had a very bad bout with tuberculosis.[5][6] Florida City, which borders the Everglades, is the southernmost city in the United States that is not on an island. It was an extremely remote location with very little development at the time. The castle remained in Florida City until about 1936 when Leedskalnin decided to move and take the castle with him. Its second and final location has the mailing address of 28655 South Dixie Highway, Miami, FL 33033, which now appears within the census-generated overlay of Leisure City but which is actually unincorporated county territory. He reportedly chose relocation as a means to protect his privacy when discussion about developing land in the original area of the castle started.[7] He spent three years moving the component structures of Coral Castle 10 miles (16 km) north from Florida City to its current location outside Homestead, Florida.\r\n" + 
				"\r\n" + 
				"Leedskalnin named his new place \"Rock Gate\" after the huge rear swinging gate he built into the back wall. He continued to work on the castle up until his death in 1951. The coral pieces that are part of the newer castle, not among those transported from the original location, were quarried on the property only a few feet away from the castle's walls. The pool and the pit beside the southern wall are quarries. The east and west quarries have been filled in.\r\n" + 
				"\r\n" + 
				"At Florida City, Leedskalnin charged visitors ten cents apiece to tour the castle grounds, but after moving to Homestead, he asked for donations of twenty five cents, but let visitors enter free if they had no money. There are signs carved into rocks at the front gate to \"Ring Bell Twice.\" He would come down from his living quarters in the second story of the castle tower close to the gate and conduct the tour. Leedskalnin never told anyone who asked him how he made the castle. He would simply answer \"It's not difficult if you know how.\"\r\n" + 
				"\r\n" + 
				"When asked why he had built the castle, Leedskalnin would vaguely answer it was for his \"Sweet Sixteen\". This is widely believed to be a reference to Agnes Skuvst (often misspelled as \"Scuffs\"). In Leedskalnin's own publication A Book in Every Home, he implies his \"Sweet Sixteen\" was more an ideal than a reality. According to a Latvian account, the girl existed, but her name was actually Hermīne Lūsis.[8]\r\n" + 
				"\r\n" + 
				"When Leedskalnin became ill in November 1951, he put a sign on the door of the front gate \"Going to the Hospital\" and took the bus to Jackson Memorial Hospital in Miami. Leedskalnin suffered a stroke at one point, either before he left for the hospital or at the hospital. He died twenty-eight days later of Pyelonephritis (a kidney infection) at the age of 64. His death certificate noted that his death was a result of \"uremia; failure of kidneys, as a result of the infection and abscess.\"[9]\r\n" + 
				"\r\n" + 
				"While the property was being investigated, $3,500 was found among Leedskalnin's personal belongings. Leedskalnin had made his income from conducting tours, selling pamphlets about various subjects (including magnetic currents) and the sale of a portion of his 10-acre (4.0 ha) property for the construction of U.S. Route 1.[7] As Leedskalnin had no will, the castle became the property of his closest living relative in America, a nephew from Michigan named Harry.[10]\r\n" + 
				"\r\n" + 
				"Coral Castle's website reports that the nephew was in poor health and he sold the castle to an Illinois family in 1953. However, this story differs from the obituary of a former Coral Castle owner, Julius Levin, a retired jeweler from Chicago, Illinois. The obituary states Levin had purchased the land from the state of Florida in 1952 and may not have been aware there was even a castle on the land.[11]\r\n" + 
				"\r\n" + 
				"The new owners turned it into a tourist attraction and changed the name of Rock Gate to Rock Gate Park, and later to Coral Castle.[12]\r\n" + 
				"\r\n" + 
				"In January 1981, Levin sold the castle to Coral Castle, Inc., for $175,000.[13] The company retains ownership today.\r\n" + 
				"\r\n" + 
				"In 1984, the property was listed on the National Register of Historic Places.[1] It was added under the name of \"Rock Gate\", but the name on the list was changed to \"Coral Castle\" in 2011.[14]\r\n" + 
				"\r\n" + 
				"The stone sign just inside the property that says \"Adm. 10c Drop Below\" is not original to Coral Castle. Ed made this sign and placed it in front of his earlier location at Florida City when he was tired of giving a \"free show\" to visitors who were careless and trampled his shrubbery. This sign was donated by the owners of Ed's Place and placed here in recent years.");
		sections.add(section);
		
		section = new Section();
		section.setTitle("The Castle");
		section.setContent("The grounds of Coral Castle consist of 1,100 short tons (1,000 t) of stones in the form of walls, carvings, furniture and a castle tower. Commonly believed to be made of coral, it is made of oolite, also known as oolitic limestone. Oolite is a sedimentary rock composed of small spherical grains of concentrically layered carbonate that may include localized concentrations of fossil shells and coral. Oolite is found throughout southeastern Florida from Palm Beach County to the Florida Keys.[15] Oolite is often found beneath only several inches of topsoil, such as at the Coral Castle site.\r\n" + 
				"\r\n" + 
				"The stones are fastened together without mortar. They are set on top of each other using their weight to keep them together. The craftsmanship detail is so skillful and the stones are connected with such precision that no light passes through the joints. The 8-foot (2.4 m) tall vertical stones that make up the perimeter wall have a uniform height. Even with the passage of decades the stones have not shifted.\r\n" + 
				"\r\n" + 
				"Many of the features and carvings of the castle are notable. Among them are a two-story castle tower that served as Leedskalnin's living quarters (walls consisting of 8-foot-high pieces of stone); an accurate sundial; a Polaris telescope; an obelisk; a barbecue; a water well; a fountain; celestial stars and planets; and numerous pieces of furniture. The furniture pieces include a heart-shaped table, a table in the shape of Florida, twenty-five rocking chairs, chairs resembling crescent moons, a bathtub, beds and a throne.\r\n" + 
				"\r\n" + 
				"With few exceptions, the objects are made from single pieces of stone that weigh on average 15 short tons (14 t) each. The largest stone weighs 30 short tons (27 t) and the tallest are two monoliths standing 25 ft (7.6 m) each.\r\n" + 
				"\r\n" + 
				"A 9-short-ton (8.2 t) revolving 8-foot tall gate is a famous structure of the castle, documented on the television programs In Search of...[16] and That's Incredible!.[17] The gate is carved so that it fits within a quarter of an inch of the walls. It was well-balanced, reportedly so that a child could open it with the push of a finger. The mystery of the gate's perfectly balanced axis and the ease with which it revolved lasted for decades until it stopped working in 1986. In order to remove it, six men and a 50-short-ton (45 t) crane were used. Once the gate was removed, the engineers discovered how Leedskalnin had centered and balanced it. He had drilled a hole from top to bottom and inserted a metal shaft. The rock rested on an old truck bearing. It was the rusting out of this bearing that resulted in the gate's failure to revolve. Complete with new bearings and shaft, it was set back into place on July 23, 1986.[18] It failed in 2005 and was again repaired; however, it does not rotate with the same ease it once did.\r\n" + 
				"\r\n" + 
				"Coral Castle remains a popular tourist attraction. Books, magazines, and television programs speculate about how Leedskalnin was able to construct the structure and move stones that weigh many tons. Claims that nobody had ever seen Leedskalnin at work and that he levitated his stones have been repudiated. Orval Irwin reportedly witnessed him quarry his stones and erect parts of his wall, and illustrated the methods in his book Mr. Can't Is Dead.[19] The Nemith Film Collection produced a short film documentary in 1944 of him at work. Coral Castle's website states that, \"If anyone ever questioned Ed about how he moved the blocks of coral, Ed would only reply that he understood the laws of weight and leverage well.\"[7] He also stated that he had \"discovered the secrets of the pyramids\", referring to the Great Pyramid of Giza.[20]");
		sections.add(section);
		
		article.setSections(sections);

		session.save(article);
		
		//ARTICLE 3
		
		article = new Article();
		article.setTitle("Cicada 3301");
		
		sections = new ArrayList<Section>();
		
		section = new Section();
		section.setTitle("Summary");
		section.setContent("Cicada 3301 is a nickname given to an organization that on three occasions has posted a set of puzzles to recruit codebreakers/linguists from the public.[1] The first internet puzzle started on January 4, 2012 and ran for approximately one month. A second round began one year later on January 4, 2013, and a third round following the confirmation of a fresh clue posted on Twitter on January 4, 2014.[2][3] The stated intent was to recruit \"intelligent individuals\" by presenting a series of puzzles which were to be solved. No new puzzles were published on January 4, 2015. However, a new clue was posted on Twitter on January 5, 2016.[4][5] In April 2017 a verified PGP-signed message was found: Beware false paths. Always verify PGP signature from 7A35090F.[6] That message explicitly denies the validity of any unsigned puzzle, as recently as April 2017.\r\n" + 
				"\r\n" + 
				"The puzzles focused heavily on data security, cryptography, and steganography.[1][7][8][9][10]\r\n" + 
				"\r\n" + 
				"It has been called \"the most elaborate and mysterious puzzle of the internet age\"[11] and is listed as one of the \"top 5 eeriest, unsolved mysteries of the internet\",[12] and much speculation exists as to its function. Many have speculated that the puzzles are a recruitment tool for the NSA, CIA, MI6, a \"Masonic conspiracy\"[13] or a cyber mercenary group.[1][8] Others have claimed Cicada 3301 is an alternate reality game. No company or individual has taken credit for it or attempted to monetize it, however.[11]");
		sections.add(section);

		section = new Section();
		section.setTitle("Purpose");
		section.setContent("The stated purpose of the puzzles each year has been to recruit \"highly intelligent individuals\", though the ultimate purpose remains unknown.[1] Some[14] have claimed that Cicada 3301 is a secret society with the goal of improving cryptography, privacy and anonymity.[15] Others[16] have claimed that Cicada 3301 is a cult or religion. According to statements of several people, who claimed to have won the 2012 puzzle, 3301 typically uses non-puzzle-based recruiting methods, but created the Cicada puzzles because they were looking for potential members with cryptography and computer security skills.[14]");
		sections.add(section);
		
		section = new Section();
		section.setTitle("Resolution");
		section.setContent("Unidentified individuals have claimed to have completed the process, but verification from the organization was never made and the individuals making the claim have not been forthcoming with information.[8][9][17] The first puzzle, of 2012, is claimed to have been solved by Marcus Wanner.[14] According to Marcus Wanner, those who solved the puzzles were asked questions about their support of information freedom, online privacy and freedom, and rejection of censorship. Those who answered satisfactorily at this stage were invited to a private forum, where they were instructed to devise and complete a project intended to further the ideals of the group.[14] He did not finish his work on a method of general decryption, and the website was removed.");
		sections.add(section);
		
		article.setSections(sections);

		session.save(article);
		
		//ARTICLE 4
		
		article = new Article();
		article.setTitle("Nibiru cataclysm");
		
		sections = new ArrayList<Section>();
		
		section = new Section();
		section.setTitle("Summary");
		section.setContent("The Nibiru cataclysm is a supposed disastrous encounter between the Earth and a large planetary object (either a collision or a near-miss) that certain groups believe will take place in the early 21st century. Believers in this doomsday event usually refer to this object as Nibiru or Planet X. The idea was first put forward in 1995 by Nancy Lieder,[2][3] founder of the website ZetaTalk. Lieder describes herself as a contactee with the ability to receive messages from extraterrestrials from the Zeta Reticuli star system through an implant in her brain. She states that she was chosen to warn mankind that the object would sweep through the inner Solar System in May 2003 (though that date was later postponed) causing Earth to undergo a physical pole shift that would destroy most of humanity.[4]\r\n" + 
				"\r\n" + 
				"The prediction has subsequently spread beyond Lieder's website and has been embraced by numerous Internet doomsday groups. In the late 2000s, it became closely associated with the 2012 phenomenon. Since 2012, the Nibiru cataclysm has frequently reappeared in the popular media, usually linked to newsmaking astronomical objects such as Comet ISON or Planet Nine. Although the name \"Nibiru\" is derived from the works of the ancient astronaut writer Zecharia Sitchin and his interpretations of Babylonian and Sumerian mythology, he denied any connection between his work and various claims of a coming apocalypse. A prediction by self-described \"Christian numerologist\" David Meade that the Nibiru cataclysm would occur on 23 September 2017 received extensive media coverage.\r\n" + 
				"\r\n" + 
				"The idea that a planet-sized object will collide with or closely pass by Earth in the near future is not supported by any scientific evidence and has been rejected by astronomers and planetary scientists as pseudoscience and an Internet hoax.[5][6] Such an object would have destabilised the orbits of the planets to the extent that their effects would be easily observable today.[7] Astronomers have hypothesized many planets beyond Neptune, and though many have been disproved, there are some that remain viable candidates such as Planet Nine. All the current candidates are in orbits that keep them well beyond Neptune throughout their orbit, even when they are closest to the Sun.");
		sections.add(section);

		section = new Section();
		section.setTitle("History");
		section.setContent("The idea of the Nibiru encounter originated with Nancy Lieder, a Wisconsin woman who claims that as a girl she was contacted by gray extraterrestrials called Zetas, who implanted a communications device in her brain. In 1995, she founded the website ZetaTalk to disseminate her ideas.[8] Lieder first came to public attention on Internet newsgroups during the build-up to Comet Hale–Bopp's 1997 perihelion. She stated, claiming to speak as the Zetas,[9] that \"The Hale–Bopp comet does not exist. It is a fraud, perpetrated by those who would have the teeming masses quiescent until it is too late. Hale–Bopp is nothing more than a distant star, and will draw no closer.\"[9] She claimed that the Hale–Bopp story was manufactured to distract people from the imminent arrival of a large planetary object, \"Planet X\", which would soon pass by Earth and destroy civilization.[9] After Hale–Bopp's perihelion revealed it as one of the brightest and longest-observed comets of the last century,[10] Lieder removed the first two sentences of her initial statement from her site, though they can still be found in Google's archives.[9] Her claims eventually made the New York Times.[11]\r\n" + 
				"\r\n" + 
				"Lieder described Planet X as roughly four times the size of the Earth, and said that its closest approach would occur on May 27, 2003, resulting in the Earth's rotation ceasing for exactly 5.9 terrestrial days. This would be followed by the Earth's pole destabilising in a pole shift (a physical pole shift, with the Earth's pole physically moving, rather than a geomagnetic reversal) caused by magnetic attraction between the Earth's core and the magnetism of the passing planet. This in turn would disrupt the Earth's magnetic core and lead to subsequent displacement of the Earth's crust.[12] After the 2003 date passed without incident, Lieder said that it was merely a \"white lie ... to fool the establishment.\"[13] She refused to disclose the true date, saying that to do so would give those in power enough time to declare martial law and trap people in cities during the shift, leading to their deaths.[14]");
		sections.add(section);
		
		section = new Section();
		section.setTitle("Scientific Rejection");
		section.setContent("Astronomers reject the idea of Nibiru, and have made efforts to inform the public that there is no threat to Earth.[49] They point out that such an object so close to Earth would be easily visible to the naked eye, and would create noticeable effects in the orbits of the outer planets.[50][21] Most photographs purporting to show \"Nibiru\" beside the Sun are lens flares, false images of the Sun created by reflections within the lens.[51] Claims that the object has been concealed behind the Sun are untenable.[21]\r\n" + 
				"\r\n" + 
				"An orbit like that of Nibiru within our Solar System is inconsistent with celestial mechanics. David Morrison, NASA space scientist explains that after just one previous flyby of Earth, such as they claim happened in Sumerian times, Earth itself would no longer be in its current near circular orbit and would be likely to have lost its Moon. If Nibiru were a brown dwarf it would have even worse effects, as brown dwarfs are far more massive.[52] Since Pluto is now frequently observed by backyard telescopes, any giant planet beyond Pluto would be easily observed by an amateur astronomer.[50] And if such an object existed in our Solar System, it would have passed through the inner Solar System a million times by now. [52]\r\n" + 
				"\r\n" + 
				"Astronomer Mike Brown notes that if this object's orbit were as described, it would only have remained in the Solar System for about a million years before Jupiter expelled it, and, even if such a planet existed, its magnetic field would have no effect on Earth's.[53] Lieder's assertions that the approach of Nibiru would cause the Earth's rotation to stop or its axis to shift violate the laws of physics. In his rebuttal of Immanuel Velikovsky's Worlds in Collision, which made the same claim that the Earth's rotation could be stopped and then restarted, Carl Sagan noted that, \"the energy required to brake the Earth is not enough to melt it, although it would result in a noticeable increase in temperature: The oceans would [be] raised to the boiling point of water ... [Also,] how does the Earth get started up again, rotating at approximately the same rate of spin? The Earth cannot do it by itself, because of the law of the conservation of angular momentum.\"[54]\r\n" + 
				"\r\n" + 
				"In a 2009 interview with the Discovery Channel, Mike Brown noted that, while it is not impossible that the Sun has a distant planetary companion, such an object would have to be lying very far from the observed regions of the Solar System to have no detectable gravitational effect on the other planets. A Mars-sized object could lie undetected at 300 AU (10 times the distance of Neptune); a Jupiter-sized object at 30,000 AU. To travel 1000 AU in two years, an object would need to be moving at 2400 km/s – faster than the galactic escape velocity. At that speed, any object would be shot out of the Solar System, and then out of the Milky Way galaxy into intergalactic space.[55]");
		sections.add(section);
		
		article.setSections(sections);

		session.save(article);
		
		
		//ARTICLE 5
		
		article = new Article();
		article.setTitle("Utsuro-bune");
		
		sections = new ArrayList<Section>();
		
		section = new Section();
		section.setTitle("Summary");
		section.setContent("Utsuro-bune (うつろ舟 'hollow ship'), also Utsuro-fune, and Urobune, refers to an unknown object that allegedly washed ashore in 1803 in Hitachi province on the eastern coast of Japan. When defining Utsuro-bune, the bune part means \"boat\" while Utsuro means empty, or hollow. Accounts of the tale appear in three texts: Toen shōsetsu (1825), Hyōryū kishū (1835) and Ume-no-chiri (1844).\r\n" + 
				"\r\n" + 
				"According to legend, an attractive young woman aged 18-20 years old, arrived on a local beach aboard the \"hollow ship\" on February 22, 1803. Fishermen brought her inland to investigate further, but the woman was unable to communicate in Japanese. She was very different than anyone there. The fishermen then returned her and her vessel to the sea, where it drifted away.\r\n" + 
				"\r\n" + 
				"Historians, ethnologists and physicists such as Kazuo Tanaka and Yanagita Kunio have evaluated the \"legend of the hollow boat\" as part of a long-standing tradition within Japanese folklore.[1][2] Alternatively, certain ufologists have claimed that the story represents evidence for a close encounter of the third kind.[3]");
		sections.add(section);

		section = new Section();
		section.setTitle("Historical Sources");
		section.setContent("The best-known versions of the legend are found in three texts:\r\n" + 
				"\r\n" + 
				"Toen shōsetsu (兎園小説, \"tales from the rabbit garden\"), composed in 1825 by Kyokutei Bakin. The manuscript is today on display at the Mukyū-Kai-Toshokan at Machida (Tokyo prefecture).\r\n" + 
				"Hyōryū kishū (漂流紀集, \"diaries and stories of castaways\"), composed during the Edo period in 1835 by an unknown author. It is today on display at the library of the Tenri University at Tenri in the Nara prefecture.\r\n" + 
				"Ume-no-chiri (梅の塵, \"dust of the apricot\"), composed in 1844 by Nagahashi Matajirō. It is today on display at the private library Iwase-Bunko-Toshokan (岩瀬文庫図書館) at Nara.\r\n" + 
				"Description in all three books bear similarity, thus they seem to have the same historical origins. The book Toen shōsetsu contains the most detailed version.[1][2][3][4]");
		sections.add(section);
		
		section = new Section();
		section.setTitle("Legend");
		section.setContent("On February 22, 1803, local fishers of the Harayadori (はらやどり) shore in the Hitachi province[5] saw an ominous \"ship\" drifting in the waters. Curious, they towed the vessel back to land, discovering that it was 3.30 metres (10.83 feet) high and 5.45 metres (17.88 feet) wide, reminding the witnesses of a Kōhako (Japanese incense burner). Its upper part appeared to be made of red coated rosewood, while the lower part was covered with brazen plates, obviously to protect it against the sharp-edged rocks. The upper part had several windows made of glass or crystal, covered with bars and clogged with some kind of tree resin. The shape of the hollow boat resembled a wooden rice pit. The windows were completely transparent and the baffled fishermen looked inside. The inner side of the Utsuro-bune was decorated with texts written in an unknown language. The fishermen found items inside such as two bed sheets, a bottle filled with 3.6 litres of water, some cake and kneaded meat. Then the fishermen saw a beautiful young woman, possibly 18 or 20 years old. Her body size was said to be 1.5 metres (4.92 feet). The woman had red hair and eyebrows, the hair elongated by artificial white extensions. The extensions could have been made of white fur or thin, white-powdered textile streaks. This hairstyle cannot be found in any literature. The skin of the lady was a very pale pink color. She wore precious, long and smooth clothes of unknown fabrics. The woman began speaking, but no one understood her. She did not seem to understand the fishermen either, so no one could ask her about her origin. Although the mysterious woman appeared friendly and courteous, she acted oddly, for she always clutched a quadratic box made of pale material and around 0.6 m (24 in) in size. The woman did not allow anyone to touch the box, no matter how kindly or pressingly the witnesses asked.\r\n" + 
				"\r\n" + 
				"An old man from the village said in theory, \"This woman could be a princess of a foreign realm, who married at her homeland. But when she had an affair with a townsman after marriage, it caused a scandal and the lover was killed for punishment. The princess was banned from home, for she enjoyed lots of sympathy, so she escaped the death penalty. Instead, she might have been exposed in that Utsuro-bune to leave her to destiny. If this should be correct, the quadratic box may contain the head of the woman's deceased lover. In the past, a very similar object with a woman was washed ashore on a close-by beach. During this incident, a small board with a pinned head was found. The content of the box could therefore be the same, which would certainly explain why she protects it so much. It would cost lots of money and time to investigate the woman and her boat. Since it seems to be tradition to expose those boats at sea, we should bring the woman back to the Utsuro-bune and let her drift away. The townspeople were frightened. In a different version, the lady from the hollow boat stays where she landed and grows to old age. From human sight it might be cruel, but it seems to be her predetermined destiny.\" The fishermen reassembled the Utsuro-bune, placed the woman in it, and set it to drift away into the ocean.[1][2][3]");
		sections.add(section);
		
		article.setSections(sections);

		session.save(article);
		
		//ARTICLE 6
		
		
		article = new Article();
		article.setTitle("Lizard Man of Scape Ore Swamp");
		
		sections = new ArrayList<Section>();
		
		section = new Section();
		section.setTitle("Summary");
		section.setContent("In the folklore of Lee County, South Carolina, the Lizard Man of Scape Ore Swamp (also known as the Lizard Man of Lee County) is an entity said to inhabit the swampland of the region. First mentioned in the late 1980s by a local 17-year-old, the purported sighting yielded a significant amount of newspaper, radio and television publicity. According to Lee County authorities, another local man admitted fabricating a story about encountering and shooting the creature \"because he wanted to keep the legend of the Lizard Man alive\" .[1]");
		sections.add(section);

		section = new Section();
		section.setTitle("History");
		section.setContent("In 1988, 17-year-old local Christopher Davis claimed his car was damaged by a creature he described as \"green, wetlike, about 7 feet tall and had three fingers, red eyes, skin like a lizard, snakelike scales\". Coverage by newspapers and media resulted in increased attention for his claims. According to Davis, he was driving home from working the night shift at a fast food restaurant when his car got a flat tire. After fixing it, he saw the creature walking toward him. Davis got in his car and began to drive, but the creature was soon on top of the car. He applied his brakes, causing the creature to roll off the car, giving Davis enough time to escape. Local businesses began selling \"Lizard Man\" T-shirts, and the local chamber of commerce encouraged the media attention as \"good for the community\".[2][3][4][5][6]\r\n" + 
				"\r\n" + 
				"The increase in newspaper and media publicity prompted further reports of sightings, and the area soon became a tourist attraction for visitors and hunters. Local radio station WCOS offered a $1 million reward to anybody who could capture the creature alive.[2] On August 5, Kenneth Orr, an airman stationed at Shaw Air Force Base, filed a police report alleging that he had encountered the Lizard Man on highway 15, and he had shot and wounded it. He presented several scales and a small quantity of blood as evidence. Orr recanted this account two days later when he was arraigned for unlawfully carrying a pistol and the misdemeanor offense of filing a false police report. According to Orr, he had hoaxed the sighting in order to keep stories about the Lizard Man in circulation.[1][7] Reports of the creature gradually declined at the end of the summer. Local law enforcement officials speculated that the sightings were likely to have been caused by a bear.[7]\r\n" + 
				"\r\n" + 
				"In 2008, CNN mentioned the Lizard Man legend in a story about a couple in Bishopville, South Carolina who reported damage to their vehicle, including blood traces.[8] The blood traces were subsequently found to be from a domestic dog, most likely a coyote or wolf.[9] In 2010, the TV program Destination Truth featured the legendary creature.[10] In 2015, local television station WCIV featured photos and videos claimed to be Lizard Man, allegedly taken by unidentified individuals.[11]");
		sections.add(section);
		
		article.setSections(sections);

		session.save(article);
		

		
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateArticle(Article article) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(article);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public void insertArticle(Article article) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(article);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public Article getArticleByTitle(String title) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Article article = session.get(Article.class, title);
		if(article != null) {
			Hibernate.initialize(article.getSections());
		}
		
		session.getTransaction().commit();
		session.close();
		
		return article;
	}
	
	public Article getArticleById(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Article article = session.get(Article.class, id);
		Hibernate.initialize(article.getSections());

		
		session.getTransaction().commit();
		session.close();
		
		return article;
	}
	
	public List<Article> getAllArticles(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Article> articles = new ArrayList<Article>();
		articles = session.createNamedQuery("Article.getAll",Article.class).getResultList();
		
		for(Article article : articles) {
			Hibernate.initialize(article.getSections());
		}
		
		session.getTransaction().commit();
		session.close();
		
		return articles;
	}
	
	public void deleteArticle(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Article article = session.get(Article.class, id);
		session.remove(article);
		
		session.getTransaction().commit();
		session.close();
	
	}
	
	public void deleteArticle(String title) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Article article = session.get(Article.class, title);
		session.remove(article);
		
		session.getTransaction().commit();
		session.close();
	
	}
	
}
