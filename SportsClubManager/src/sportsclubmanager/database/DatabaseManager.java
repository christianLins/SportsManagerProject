/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.database;

import java.text.*;
import java.util.*;
import java.util.logging.*;
import sportsclubmanager.domain.*;
import sportsclubmanager.domain.classes.*;
import sportsclubmanager.domain.contract.*;

/**
 @author Thomas
 */
public class DatabaseManager
{
    public static void clearDatabase()
    {
        try
        {
            DomainFacade.delete(Match.class);
            DomainFacade.delete(Competition.class);
            DomainFacade.delete(League.class);

            DomainFacade.delete(ClubTeam.class);
            DomainFacade.delete(Team.class);

            DomainFacade.delete(Department.class);
            DomainFacade.delete(Player.class);
            DomainFacade.delete(DepartmentHead.class);
            DomainFacade.delete(Trainer.class);
            DomainFacade.delete(Member.class);
            DomainFacade.delete(Country.class);
            DomainFacade.delete(TypeOfSport.class);
        }
        catch (CouldNotDeleteException ex)
        {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void restoreDefault()
    {
        clearDatabase();

        restoreTypeOfSport();
        restoreCountry();
        restorePlayer();
        restoreTrainer();

        restoreDepartmentHead();
        restoreDepartment();

        restoreClubTeams();
        restoreTeams();

        restoreCompetitions();
    }

    private static void restoreTypeOfSport()
    {
        String[] values = new String[]
        {
            "Basketball",
            "Baseball",
            "American Football",
            "Football",
            "Cricket",
            "Hockey",
            "Ice hockey",
            "Rugby",
            "Curling",
            "Fistball",
            "Volleyball",
            "Beachvolleyball"
        };
        try
        {
            for (String value : values)
            {

                TypeOfSport type = new TypeOfSport();
                type.setName(value);
                type.setDescription("");
                DomainFacade.set(type);

            }
        }
        catch (CouldNotSaveException ex)
        {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void restoreCountry()
    {
        try
        {
            DomainFacade.set(new Country("AFG", "AF", ".af", " Afghanistan", "Afghanistan", "Afganistán", " Afghanistan", "Afghanistan", " Afeganistão"));
            DomainFacade.set(new Country("ALB", "AL", ".al", "Albania", "Albanien", "Albania", " Albanie", "Albania", " Albânia"));
            DomainFacade.set(new Country("ATA", "AQ", ".aq", "Antarctica", "Antarktis", "Antártida", " Antarctique", "Antartide", " Antárctida"));
            DomainFacade.set(new Country("DZA", "DZ", ".dz", "Algeria", "Algerien", "Argelia", " Algerie !Algérie", "Algeria", " Argélia"));
            DomainFacade.set(new Country("ASM", "AS", ".as", "American Samoa", "Amerikanisch-Samoa", "Samoa Americana", " Samoa americaines !Samoa américaines", "Samoa Americane", " Samoa Americana"));
            DomainFacade.set(new Country("AND", "AD", ".ad", "Andorra", "Andorra", "Andorra", " Andorre", "Andorra", " Andorra"));
            DomainFacade.set(new Country("AGO", "AO", ".ao", "Angola", "Angola", "Angola", " Angola", "Angola", " Angola"));
            DomainFacade.set(new Country("ATG", "AG", ".ag", "Antigua and Barbuda", "Antigua und Barbuda", "Antigua y Barbuda", " Antigua-et-Barbuda", "Antigua e Barbuda", " Antigua e Barbuda"));
            DomainFacade.set(new Country("AZE", "AZ", ".az", "Azerbaijan", "Aserbaidschan", "Azerbaiyán", " Azerbaidjan !Azerbaïdjan", "Azerbaijan", " Azerbeijão"));
            DomainFacade.set(new Country("ARG", "AR", ".ar", "Argentina", "Argentinien", "Argentina", " Argentine", "Argentina", " Argentina"));
            DomainFacade.set(new Country("AUS", "AU", ".au", "Australia", "Australien", "Australia", " Australie", "Australia", " Austrália"));
            DomainFacade.set(new Country("AUT", "AT", ".at", "Austria", "Österreich", "Austria", " Autriche", "Austria", " Áustria"));
            DomainFacade.set(new Country("BHS", "BS", ".bs", "Bahamas", "Bahamas", "Bahamas", " Bahamas", "Bahamas", " Bahamas"));
            DomainFacade.set(new Country("BHR", "BH", ".bh", "Bahrain", "Bahrain", "Bahréin", " Bahrein !Bahreïn", "Bahrain", " Bahrain"));
            DomainFacade.set(new Country("BGD", "BD", ".bd", "Bangladesh", "Bangladesch", "Bangladesh", " Bangladesh", "Bangladesh", " Bangladesh"));
            DomainFacade.set(new Country("ARM", "AM", ".am", "Armenia", "Armenien", "Armenia", " Armenie !Arménie", "Armenia", " Arménia"));
            DomainFacade.set(new Country("BRB", "BB", ".bb", "Barbados", "Barbados", "Barbados", " Barbade", "Barbados", " Barbados"));
            DomainFacade.set(new Country("BEL", "BE", ".be", "Belgium", "Belgien", "Bélgica", " Belgique", "Belgio", " Bélgica"));
            DomainFacade.set(new Country("BMU", "BM", ".bm", "Bermuda", "Bermuda", "Bermudas", " Bermudes", "Bermuda", " Bermuda"));
            DomainFacade.set(new Country("BTN", "BT", ".bt", "Bhutan", "Bhutan", "Bután", " Bhoutan", "Bhutan", " Butão"));
            DomainFacade.set(new Country("BOL", "BO", ".bo", "Bolivia", "Bolivien", "Bolivia", " Bolivie", "Bolivia", " Bolívia"));
            DomainFacade.set(new Country("BIH", "BA", ".ba", "Bosnia and Herzegovina", "Bosnien und Herzegowina", "Bosnia y Herzegovina", " Bosnie-Herzégovine", "Bosnia-Erzegovina", " Bósnia-Herzegovina"));
            DomainFacade.set(new Country("BWA", "BW", ".bw", "Botswana", "Botswana", "Botsuana", " Botswana", "Botswana", " Botswana"));
            DomainFacade.set(new Country("BVT", "BV", ".bv", "Bouvet Island", "Bouvetinsel", "Isla Bouvet", " Ile Bouvet !Île Bouvet", "Isola Bouvet", " Ilha Bouvet"));
            DomainFacade.set(new Country("BRA", "BR", ".br", "Brazil", "Brasilien", "Brasil", " Bresil !Brésil", "Brasile", " Brasil"));
            DomainFacade.set(new Country("BLZ", "BZ", ".bz", "Belize", "Belize", "Belice", " Belize", "Belize", " Belize"));
            DomainFacade.set(new Country("IOT", "IO", ".io", "British Indian Ocean Territory", "Britisches Territorium im Indischen Ozean", "Territorio Británico del Océano Índico", " Territoire britannique de locean Indien !Territoire britannique de locéan Indien", "Territorio Britannico dellOceano Indiano", " Território Britânico do Oceano Índico"));
            DomainFacade.set(new Country("SLB", "SB", ".sb", "Solomon Islands", "Salomonen", "Islas Salomón", " Iles Salomon !Îles Salomon", "Isole Solomon", " Ilhas Salomão"));
            DomainFacade.set(new Country("VGB", "VG", ".vg", "Virgin Islands, British", "Britische Jungferninseln", "Islas Vírgenes Británicas", " Iles vierges britanniques !Îles Vierges britanniques", "Territori Britannici dellOceano Indiano", " Ilhas Virgens Britânicas"));
            DomainFacade.set(new Country("BRN", "BN", ".bn", "Brunei Darussalam", "Brunei Darussalam", "Brunéi", " Brunei", "Brunei Darussalam", " Brunei"));
            DomainFacade.set(new Country("BGR", "BG", ".bg", "Bulgaria", "Bulgarien", "Bulgaria", " Bulgarie", "Bulgaria", " Bulgária"));
            DomainFacade.set(new Country("BUR", "BU", ".mm", "Myanmar", "Myanmar (Burma)", "Myanmar", " Birmanie", "Myanmar", " Myanmar (antiga \"\"Birmânia\"\")"));
            DomainFacade.set(new Country("MMR", "MM", ".mm", "Myanmar", "Myanmar (Burma)", "Myanmar", " Birmanie", "Myanmar", " Myanmar (antiga \"\"Birmânia\"\")"));
            DomainFacade.set(new Country("BDI", "BI", ".bi", "Burundi", "Burundi", "Burundi", " Burundi", "Burundi", " Burundi"));
            DomainFacade.set(new Country("BLR", "BY", ".by", "Belarus", "Belarus (Weißrussland)", "Bielorrusia", " Bielorussie !Biélorussie", "Bielorussia", " Bielo-Rússia"));
            DomainFacade.set(new Country("KHM", "KH", ".kh", "Cambodia", "Kambodscha", "Camboya", " Cambodge", "Cambogia", " Cambodja"));
            DomainFacade.set(new Country("CMR", "CM", ".cm", "Cameroon", "Kamerun", "Camerún", " Cameroun", "Camerun", " Camarões"));
            DomainFacade.set(new Country("CAN", "CA", ".ca", "Canada", "Kanada", "Canadá", " Canada", "Canada", " Canadá"));
            DomainFacade.set(new Country("CPV", "CV", ".cv", "Cape Verde", "Kap Verde", "Cabo Verde", " Cap-Vert", "Capo Verde", " Cabo Verde"));
            DomainFacade.set(new Country("CYM", "KY", ".ky", "Cayman Islands", "Kaimaninseln", "Islas Caimán", " Îles Caïmanes", "Isole Cayman", " Ilhas Cayman"));
            DomainFacade.set(new Country("CAF", "CF", ".cf", "Central African Republic", "Zentralafrikanische Republik", "República Centroafricana", " Centrafrique", "Repubblica Centroafricana", " República Centro-africana"));
            DomainFacade.set(new Country("LKA", "LK", ".lk", "Sri Lanka", "Sri Lanka", "Sri Lanka", " Sri Lanka", "Sri Lanka", " Sri Lanka"));
            DomainFacade.set(new Country("TCD", "TD", ".td", "Chad", "Tschad", "Chad", " Tchad", "Ciad", " Chade"));
            DomainFacade.set(new Country("CHL", "CL", ".cl", "Chile", "Chile", "Chile", " Chili", "Cile", " Chile"));
            DomainFacade.set(new Country("CHN", "CN", ".cn", "China", "China, Volksrepublik", "China", " Chine", "Cina", " China"));
            DomainFacade.set(new Country("TWN", "TW", ".tw", "Taiwan, Province of China", "Republik China (Taiwan)", "Taiwán", " Taïwan / (République de Chine)", "Taiwan", " Taiwan"));
            DomainFacade.set(new Country("CXR", "CX", ".cx", "Christmas Island", "Weihnachtsinsel", "Isla de Navidad", " Ile Christmas !Île Christmas", "Isola di Natale", " Ilha Christmas"));
            DomainFacade.set(new Country("CCK", "CC", ".cc", "Cocos (Keeling) Islands", "Kokosinseln", "Islas Cocos", " Îles Cocos", "Isole Cocos", " Ilhas Cocos"));
            DomainFacade.set(new Country("COL", "CO", ".co", "Colombia", "Kolumbien", "Colombia", " Colombie", "Colombia", " Colômbia"));
            DomainFacade.set(new Country("COM", "KM", ".km", "Comoros", "Komoren", "Comoras", " Comores", "Comore", " Comores"));
            DomainFacade.set(new Country("MYT", "YT", ".yt", "Mayotte", "Mayotte", "Mayotte", " Mayotte", "Mayotte", " Mayotte"));
            DomainFacade.set(new Country("COG", "CG", ".cg", "Congo", "Republik Kongo", "República del Congo", " Congo-Brazzaville / (Congo)", "Repubblica del Congo", " República do Congo"));
            DomainFacade.set(new Country("COD", "CD", ".cd", "Congo, Democratic Republic of the", "Zaire (jetzt Demokratische Republik Kongo)", "República Democrática del Congo", " Congo-Kinshasa / (République démocratique du Congo)", "Repubblica Democratica del Congo", " República Democrática do Congo"));
            DomainFacade.set(new Country("ZAR", "ZR", ".cd", "Congo, Democratic Republic of the", "Zaire (jetzt Demokratische Republik Kongo)", "República Democrática del Congo", " Congo-Kinshasa / (République démocratique du Congo)", "Repubblica Democratica del Congo", " República Democrática do Congo"));
            DomainFacade.set(new Country("COK", "CK", ".ck", "Cook Islands", "Cookinseln", "Islas Cook", " Îles Cook", "Isole Cook", " Ilhas Cook"));
            DomainFacade.set(new Country("CRI", "CR", ".cr", "Costa Rica", "Costa Rica", "Costa Rica", " Costa Rica", "Costa Rica", " Costa Rica"));
            DomainFacade.set(new Country("HRV", "HR", ".hr", "Croatia", "Kroatien", "Croacia", " Croatie", "Croazia", " Croácia"));
            DomainFacade.set(new Country("CUB", "CU", ".cu", "Cuba", "Kuba", "Cuba", " Cuba", "Cuba", " Cuba"));
            DomainFacade.set(new Country("CYP", "CY", ".cy", "Cyprus", "Zypern", "Chipre", " Chypre (pays)||CHYPRE", "Cipro", " Chipre"));
            DomainFacade.set(new Country("CZE", "CZ", ".cz", "Czech Republic", "Tschechische Republik", "República Checa", " Republique tcheque !République tchèque", "Repubblica Ceca", " República Checa"));
            DomainFacade.set(new Country("BEN", "BJ", ".bj", "Benin", "Benin", "Benín", " Benin !Bénin", "Benin", " Benin"));
            DomainFacade.set(new Country("DNK", "DK", ".dk", "Denmark", "Dänemark", "Dinamarca", " Danemark", "Danimarca", " Dinamarca"));
            DomainFacade.set(new Country("DMA", "DM", ".dm", "Dominica", "Dominica", "Dominica", " Dominique", "Dominica", " Dominica"));
            DomainFacade.set(new Country("DOM", "DO", ".do", "Dominican Republic", "Dominikanische Republik", "República Dominicana", " Republique dominicaine !République dominicaine", "Repubblica Dominicana", " República Dominicana"));
            DomainFacade.set(new Country("ECU", "EC", ".ec", "Ecuador", "Ecuador", "Ecuador", " Equateur !Équateur", "Ecuador", " Equador"));
            DomainFacade.set(new Country("SLV", "SV", ".sv", "El Salvador", "El Salvador", "El Salvador", " Salvador", "El Salvador", " El Salvador"));
            DomainFacade.set(new Country("GNQ", "GQ", ".gq", "Equatorial Guinea", "Äquatorialguinea", "Guinea Ecuatorial", " Guinee equatoriale !Guinée équatoriale", "Guinea Equatoriale", " Guiné Equatorial"));
            DomainFacade.set(new Country("ETH", "ET", ".et", "Ethiopia", "Äthiopien", "Etiopía", " Ethiopie !Éthiopie", "Etiopia", " Etiópia"));
            DomainFacade.set(new Country("ERI", "ER", ".er", "Eritrea", "Eritrea", "Eritrea", " Erythree !Érythrée", "Eritrea", " Eritreia"));
            DomainFacade.set(new Country("EST", "EE", ".ee", "Estonia", "Estland", "Estonia", " Estonie", "Estonia", " Estónia"));
            DomainFacade.set(new Country("FRO", "FO", ".fo", "Faroe Islands", "Färöer", "Islas Feroe", " Iles Feroe !Îles Féroé", "Isole Faroe", " Ilhas Faroe"));
            DomainFacade.set(new Country("FLK", "FK", ".fk", "Falkland Islands (Malvinas)", "Falklandinseln", "Islas Malvinas", " Iles Malouines !Îles Malouines", "Isole Falkland", " Ilhas Malvinas"));
            DomainFacade.set(new Country("SGS", "GS", ".gs", "South Georgia and the South Sandwich Islands", "Südgeorgien und die Südlichen Sandwichinseln", "Islas Georgias del Sur y Sandwich del Sur", " Géorgie du Sud et les îles Sandwich du Sud", "Sud Georgia e Isole Sandwich", " Ilhas Geórgia do Sul e Sandwich do Sul"));
            DomainFacade.set(new Country("FJI", "FJ", ".fj", "Fiji", "Fidschi", "Fiyi", " Fidji", "Fiji", " Fiji"));
            DomainFacade.set(new Country("FIN", "FI", ".fi", "Finland", "Finnland", "Finlandia", " Finlande", "Finlandia", " Finlândia"));
            DomainFacade.set(new Country("ALA", "AX", ".ax", "Åland Islands", "Åland", "Åland", " Aland !Åland", "Åland", " Åland"));
            DomainFacade.set(new Country("FRA", "FR", ".fr", "France", "Frankreich", "Francia", " France", "Francia", " França"));
            DomainFacade.set(new Country("GUF", "GF", ".gf", "French Guiana", "Französisch-Guayana", "Guayana Francesa", " Guyane", "Guyana Francese", " Guiana Francesa"));
            DomainFacade.set(new Country("PYF", "PF", ".pf", "French Polynesia", "Französisch-Polynesien", "Polinesia Francesa", " Polynesie francaise !Polynésie française", "Polinesia Francese", " Polinésia Francesa"));
            DomainFacade.set(new Country("ATF", "TF", ".tf", "French Southern Territories", "Französische Süd- und Antarktisgebiete", "Territorios Australes Franceses", " Terres australes et antarctiques françaises", "Territori Francesi del Sud", " Terras Austrais e Antárticas Francesas (\"\"TAAF\"\")"));
            DomainFacade.set(new Country("DJI", "DJ", ".dj", "Djibouti", "Dschibuti", "Yibuti", " Djibouti", "Gibuti", " Djibouti"));
            DomainFacade.set(new Country("GAB", "GA", ".ga", "Gabon", "Gabun", "Gabón", " Gabon", "Gabon", " Gabão"));
            DomainFacade.set(new Country("GEO", "GE", ".ge", "Georgia", "Georgien", "Georgia", " Géorgie (pays)", "Georgia", " Geórgia"));
            DomainFacade.set(new Country("GMB", "GM", ".gm", "Gambia", "Gambia", "Gambia", " Gambie", "Gambia", " Gâmbia"));
            DomainFacade.set(new Country("PSE", "PS", ".ps", "Palestinian Territory, Occupied", "Palästinensische Autonomiegebiete", "Palestina (ANP)", " Palestine", "Territori Palestinesi Occupati", " Palestina"));
            DomainFacade.set(new Country("DEU", "DE", ".de", "Germany", "Deutschland", "Alemania", " Allemagne", "Germania", " Alemanha"));
            DomainFacade.set(new Country("GHA", "GH", ".gh", "Ghana", "Ghana", "Ghana", " Ghana", "Ghana", " Gana"));
            DomainFacade.set(new Country("GIB", "GI", ".gi", "Gibraltar", "Gibraltar", "Gibraltar", " Gibraltar", "Gibilterra", " Gibraltar"));
            DomainFacade.set(new Country("KIR", "KI", ".ki", "Kiribati", "Kiribati", "Kiribati", " Kiribati", "Kiribati", " Kiribati"));
            DomainFacade.set(new Country("GRC", "GR", ".gr", "Greece", "Griechenland", "Grecia", " Grece !Grèce", "Grecia", " Grécia "));
            DomainFacade.set(new Country("GRL", "GL", ".gl", "Greenland", "Grönland", "Groenlandia", " Groenland", "Groenlandia", " Gronelândia"));
            DomainFacade.set(new Country("GRD", "GD", ".gd", "Grenada", "Grenada", "Granada", " Grenade (pays)||GRENADE", "Grenada", " Grenada"));
            DomainFacade.set(new Country("GLP", "GP", ".gp", "Guadeloupe", "Guadeloupe", "Guadalupe", " Guadeloupe", "Guadalupa", " Guadeloupe"));
            DomainFacade.set(new Country("GUM", "GU", ".gu", "Guam", "Guam", "Guam", " Guam", "Guam", " Guam"));
            DomainFacade.set(new Country("GTM", "GT", ".gt", "Guatemala", "Guatemala", "Guatemala", " Guatemala", "Guatemala", " Guatemala"));
            DomainFacade.set(new Country("GIN", "GN", ".gn", "Guinea", "Guinea", "Guinea", " Guinee !Guinée", "Guinea", " Guiné-Conacri"));
            DomainFacade.set(new Country("GUY", "GY", ".gy", "Guyana", "Guyana", "Guyana", " Guyana", "Guyana", " Guiana"));
            DomainFacade.set(new Country("HTI", "HT", ".ht", "Haiti", "Haiti", "Haití", " Haiti !Haïti", "Haiti", " Haiti"));
            DomainFacade.set(new Country("HMD", "HM", ".hm", "Heard Island and McDonald Islands", "Heard- und McDonald-Inseln", "Islas Heard y McDonald", " Île Heard et îles McDonald", "Isole Heard e McDonald", " Ilha Heard e Ilhas McDonald"));
            DomainFacade.set(new Country("VAT", "VA", ".va", "Holy See (Vatican City State)", "Vatikanstadt", "Ciudad del Vaticano", " Vatican / (Saint-Siège)", "Città del Vaticano", " Vaticano"));
            DomainFacade.set(new Country("HND", "HN", ".hn", "Honduras", "Honduras", "Honduras", " Honduras", "Honduras", " Honduras"));
            DomainFacade.set(new Country("HKG", "HK", ".hk", "Hong Kong", "Hongkong", "Hong Kong", " Hong Kong", "Hong Kong", " Hong Kong"));
            DomainFacade.set(new Country("HUN", "HU", ".hu", "Hungary", "Ungarn", "Hungría", " Hongrie", "Ungheria", " Hungria"));
            DomainFacade.set(new Country("ISL", "IS", ".is", "Iceland", "Island", "Islandia", " Islande", "Islanda", " Islândia"));
            DomainFacade.set(new Country("IND", "IN", ".in", "India", "Indien", "India", " Inde", "India", " Índia"));
            DomainFacade.set(new Country("IDN", "ID", ".id", "Indonesia", "Indonesien", "Indonesia", " Indonesie !Indonésie", "Indonesia", " Indonésia"));
            DomainFacade.set(new Country("IRN", "IR", ".ir", "Iran, Islamic Republic of", "Iran", "Irán", " Iran", "Iran", " Irão"));
            DomainFacade.set(new Country("IRQ", "IQ", ".iq", "Iraq", "Irak", "Iraq", " Irak", "Iraq", " Iraque"));
            DomainFacade.set(new Country("IRL", "IE", ".ie", "Ireland", "Irland", "Irlanda", " Irlande (pays)||IRLANDE", "Eire", " Irlanda"));
            DomainFacade.set(new Country("ISR", "IL", ".il", "Israel", "Israel", "Israel", " Israel !Israël", "Israele", " Israel"));
            DomainFacade.set(new Country("ITA", "IT", ".it", "Italy", "Italien", "Italia", " Italie", "Italia", " Itália"));
            DomainFacade.set(new Country("CIV", "CI", ".ci", "Côte dIvoire", "Elfenbeinküste", "Costa de Marfil", " Cote dIvoire !Côte dIvoire ", "Costa dAvorio", " Costa do Marfim"));
            DomainFacade.set(new Country("JAM", "JM", ".jm", "Jamaica", "Jamaika", "Jamaica", " Jamaique !Jamaïque", "Giamaica", " Jamaica"));
            DomainFacade.set(new Country("JPN", "JP", ".jp", "Japan", "Japan", "Japón", " Japon", "Giappone", " Japão"));
            DomainFacade.set(new Country("KAZ", "KZ", ".kz", "Kazakhstan", "Kasachstan", "Kazajistán", " Kazakhstan", "Kazakistan", " Cazaquistão"));
            DomainFacade.set(new Country("JOR", "JO", ".jo", "Jordan", "Jordanien", "Jordania", " Jordanie", "Giordania", " Jordânia"));
            DomainFacade.set(new Country("KEN", "KE", ".ke", "Kenya", "Kenia", "Kenia", " Kenya", "Kenya", " Quénia"));
            DomainFacade.set(new Country("PRK", "KP", ".kp", "Korea, Democratic Peoples Republic of", "Nordkorea", "Corea del Norte", " Coree du Nord !Corée du Nord", "Corea del Nord", " Coreia do Norte"));
            DomainFacade.set(new Country("KOR", "KR", ".kr", "Korea, Republic of", "Südkorea", "Corea del Sur", " Coree du Sud !Corée du Sud", "Corea del Sud", " Coreia do Sul"));
            DomainFacade.set(new Country("KWT", "KW", ".kw", "Kuwait", "Kuwait", "Kuwait", " Koweit !Koweït", "Kuwait", " Kuwait"));
            DomainFacade.set(new Country("KGZ", "KG", ".kg", "Kyrgyzstan", "Kirgisistan", "Kirguistán", " Kirghizistan", "Kirghizistan", " Quirguistão"));
            DomainFacade.set(new Country("LAO", "LA", ".la", "Lao Peoples Democratic Republic", "Laos", "Laos", " Laos", "Laos", " Laos"));
            DomainFacade.set(new Country("LBN", "LB", ".lb", "Lebanon", "Libanon", "Líbano", " Liban", "Libano", " Líbano"));
            DomainFacade.set(new Country("LSO", "LS", ".ls", "Lesotho", "Lesotho", "Lesoto", " Lesotho", "Lesotho", " Lesoto"));
            DomainFacade.set(new Country("LVA", "LV", ".lv", "Latvia", "Lettland", "Letonia", " Lettonie", "Lettonia", " Letónia"));
            DomainFacade.set(new Country("LBR", "LR", ".lr", "Liberia", "Liberia", "Liberia", " Liberia !Libéria", "Liberia", " Libéria"));
            DomainFacade.set(new Country("LBY", "LY", ".ly", "Libyan Arab Jamahiriya", "Libyen", "Libia", " Libye", "Libia", " Líbia"));
            DomainFacade.set(new Country("LIE", "LI", ".li", "Liechtenstein", "Liechtenstein", "Liechtenstein", " Liechtenstein", "Liechtenstein", " Liechtenstein"));
            DomainFacade.set(new Country("LTU", "LT", ".lt", "Lithuania", "Litauen", "Lituania", " Lituanie", "Lituania", " Lituânia"));
            DomainFacade.set(new Country("LUX", "LU", ".lu", "Luxembourg", "Luxemburg", "Luxemburgo", " Luxembourg (pays)", "Lussemburgo", " Luxemburgo"));
            DomainFacade.set(new Country("MAC", "MO", ".mo", "Macao", "Macao", "Macao", " Macao", "Macao", " Macau"));
            DomainFacade.set(new Country("MDG", "MG", ".mg", "Madagascar", "Madagaskar", "Madagascar", " Madagascar", "Madagascar", " Madagáscar"));
            DomainFacade.set(new Country("MWI", "MW", ".mw", "Malawi", "Malawi", "Malawi", " Malawi", "Malawi", " Malawi"));
            DomainFacade.set(new Country("MYS", "MY", ".my", "Malaysia", "Malaysia", "Malasia", " Malaisie", "Malesia", " Malásia"));
            DomainFacade.set(new Country("MDV", "MV", ".mv", "Maldives", "Malediven", "Maldivas", " Maldives", "Maldive", " Maldivas"));
            DomainFacade.set(new Country("MLI", "ML", ".ml", "Mali", "Mali", "Malí", " Mali", "Mali", " Mali"));
            DomainFacade.set(new Country("MLT", "MT", ".mt", "Malta", "Malta", "Malta", " Malte", "Malta", " Malta"));
            DomainFacade.set(new Country("MTQ", "MQ", ".mq", "Martinique", "Martinique", "Martinica", " Martinique", "Martinica", " Martinica"));
            DomainFacade.set(new Country("MRT", "MR", ".mr", "Mauritania", "Mauretanien", "Mauritania", " Mauritanie", "Mauritania", " Mauritânia"));
            DomainFacade.set(new Country("MUS", "MU", ".mu", "Mauritius", "Mauritius", "Mauricio", " Maurice (pays)", "Mauritius", " Maurícia"));
            DomainFacade.set(new Country("MEX", "MX", ".mx", "Mexico", "Mexiko", "México", " Mexique", "Messico", " México"));
            DomainFacade.set(new Country("MCO", "MC", ".mc", "Monaco", "Monaco", "Mónaco", " Monaco", "Monaco", " Mónaco"));
            DomainFacade.set(new Country("MNG", "MN", ".mn", "Mongolia", "Mongolei", "Mongolia", " Mongolie", "Mongolia", " Mongólia"));
            DomainFacade.set(new Country("MDA", "MD", ".md", "Moldova, Republic of", "Moldawien", "Moldavia", " Moldavie", "Moldavia", " Moldávia"));
            DomainFacade.set(new Country("MNE", "ME", ".me", "Montenegro", "Montenegro", "Montenegro", " Montenegro !Monténégro", "Montenegro", " Montenegro"));
            DomainFacade.set(new Country("MSR", "MS", ".ms", "Montserrat", "Montserrat", "Montserrat", " Montserrat", "Montserrat", " Montserrat"));
            DomainFacade.set(new Country("MAR", "MA", ".ma", "Morocco", "Marokko", "Marruecos", " Maroc", "Marocco", " Marrocos"));
            DomainFacade.set(new Country("MOZ", "MZ", ".mz", "Mozambique", "Mosambik", "Mozambique", " Mozambique", "Mozambico", " Moçambique"));
            DomainFacade.set(new Country("OMN", "OM", ".om", "Oman", "Oman", "Omán", " Oman", "Oman", " Oman"));
            DomainFacade.set(new Country("NAM", "NA", ".na", "Namibia", "Namibia", "Namibia", " Namibie", "Namibia", " Namíbia"));
            DomainFacade.set(new Country("NRU", "NR", ".nr", "Nauru", "Nauru", "Nauru", " Nauru", "Nauru", " Nauru"));
            DomainFacade.set(new Country("NPL", "NP", ".np", "Nepal", "Nepal", "Nepal", " Nepal !Népal", "Nepal", " Nepal"));
            DomainFacade.set(new Country("NLD", "NL", ".nl", "Netherlands", "Niederlande", "Países Bajos", " Pays-Bas", "Paesi Bassi", " Países Baixos (\"\"Holanda\"\")"));
            DomainFacade.set(new Country("ANT", "AN", ".an", "Netherlands Antilles", "Niederländische Antillen", "Antillas Neerlandesas", " Antilles neerlandaises !Antilles néerlandaises", "Antille Olandesi", " Antilhas Holandesas"));
            DomainFacade.set(new Country("ABW", "AW", ".aw", "Aruba", "Aruba", "Aruba", " Aruba", "Aruba", " Aruba"));
            DomainFacade.set(new Country("NCL", "NC", ".nc", "New Caledonia", "Neukaledonien", "Nueva Caledonia", " Nouvelle-Caledonie !Nouvelle-Calédonie", "Nuova Caledonia", " Nova Caledónia"));
            DomainFacade.set(new Country("VUT", "VU", ".vu", "Vanuatu", "Vanuatu", "Vanuatu", " Vanuatu", "Vanuatu", " Vanuatu"));
            DomainFacade.set(new Country("NZL", "NZ", ".nz", "New Zealand", "Neuseeland", "Nueva Zelanda", " Nouvelle-Zelande !Nouvelle-Zélande", "Nuova Zelanda", " Nova Zelândia (\"\"Aotearoa\"\")"));
            DomainFacade.set(new Country("NIC", "NI", ".ni", "Nicaragua", "Nicaragua", "Nicaragua", " Nicaragua", "Nicaragua", " Nicarágua"));
            DomainFacade.set(new Country("NER", "NE", ".ne", "Niger", "Niger", "Níger", " Niger", "Niger", " Níger"));
            DomainFacade.set(new Country("NGA", "NG", ".ng", "Nigeria", "Nigeria", "Nigeria", " Nigeria", "Nigeria", " Nigéria"));
            DomainFacade.set(new Country("NIU", "NU", ".nu", "Niue", "Niue", "Niue", " Niue !Niué", "Niue", " Niue"));
            DomainFacade.set(new Country("NFK", "NF", ".nf", "Norfolk Island", "Norfolkinsel", "Norfolk", " Norfolk", "Isola Norfolk", " Ilha Norfolk"));
            DomainFacade.set(new Country("NOR", "NO", ".no", "Norway", "Norwegen", "Noruega", " Norvege !Norvège", "Norvegia", " Noruega"));
            DomainFacade.set(new Country("MNP", "MP", ".mp", "Northern Mariana Islands", "Nördliche Marianen", "Islas Marianas del Norte", " Iles Mariannes du Nord !Îles Mariannes du Nord", "Isole Marianne Settentrionali", " Marianas Setentrionais"));
            DomainFacade.set(new Country("UMI", "UM", ".um", "United States Minor Outlying Islands", "United States Minor Outlying Islands", "Islas ultramarinas de Estados Unidos", " Iles mineures eloignees des Etats-Unis !Îles mineures éloignées des États-Unis", "Isole Minori degli Stati Uniti dAmerica", " Ilhas Menores Distantes dos Estados Unidos"));
            DomainFacade.set(new Country("FSM", "FM", ".fm", "Micronesia, Federated States of", "Mikronesien", "Micronesia", " Micronésie (pays)", "Stati Federati della Micronesia", " Estados Federados da Micronésia"));
            DomainFacade.set(new Country("MHL", "MH", ".mh", "Marshall Islands", "Marshallinseln", "Islas Marshall", " Marshall (pays)", "Isole Marshall", " Ilhas Marshall"));
            DomainFacade.set(new Country("PLW", "PW", ".pw", "Palau", "Palau", "Palaos", " Palaos", "Palau", " Palau"));
            DomainFacade.set(new Country("PAK", "PK", ".pk", "Pakistan", "Pakistan", "Pakistán", " Pakistan", "Pakistan", " Paquistão"));
            DomainFacade.set(new Country("PAN", "PA", ".pa", "Panama", "Panama", "Panamá", " Panamá", "Panamá", " Panamá"));
            DomainFacade.set(new Country("PNG", "PG", ".pg", "Papua New Guinea", "Papua-Neuguinea", "Papúa Nueva Guinea", " Papouasie-Nouvelle-Guinée", "Papua Nuova Guinea", " Papua-Nova Guiné"));
            DomainFacade.set(new Country("PRY", "PY", ".py", "Paraguay", "Paraguay", "Paraguay", " Paraguay", "Paraguay", " Paraguai"));
            DomainFacade.set(new Country("PER", "PE", ".pe", "Peru", "Peru", "Perú", " Perou !Pérou", "Perù", " Peru"));
            DomainFacade.set(new Country("PHL", "PH", ".ph", "Philippines", "Philippinen", "Filipinas", " Philippines", "Filippine", " Filipinas"));
            DomainFacade.set(new Country("PCN", "PN", ".pn", "Pitcairn", "Pitcairninseln", "Islas Pitcairn", " Pitcairn", "Pitcairn", " Pitcairn"));
            DomainFacade.set(new Country("POL", "PL", ".pl", "Poland", "Polen", "Polonia", " Pologne", "Polonia", " Polónia"));
            DomainFacade.set(new Country("PRT", "PT", ".pt", "Portugal", "Portugal", "Portugal", " Portugal", "Portogallo", " Portugal"));
            DomainFacade.set(new Country("GNB", "GW", ".gw", "Guinea-Bissau", "Guinea-Bissau", "Guinea-Bissau", " Guinee Bissau !Guinée-Bissau", "Guinea-Bissau", " Guiné-Bissau"));
            DomainFacade.set(new Country("TLS", "TL", ".tl", "Timor-Leste", "Osttimor", "Timor Oriental", " Timor oriental", "Timor Est", " Timor-Leste"));
            DomainFacade.set(new Country("PRI", "PR", ".pr", "Puerto Rico", "Puerto Rico", "Puerto Rico", " Porto Rico", "Porto Rico", " Porto Rico"));
            DomainFacade.set(new Country("QAT", "QA", ".qa", "Qatar", "Katar", "Qatar", " Qatar", "Qatar", " Qatar"));
            DomainFacade.set(new Country("REU", "RE", ".re", "Réunion", "Reunion", "Reunión", " Reunion !La Réunion", "Reunion", " Reunião"));
            DomainFacade.set(new Country("ROU", "RO", ".ro", "Romania", "Rumänien", "Rumania", " Roumanie", "Romania", " Roménia"));
            DomainFacade.set(new Country("RWA", "RW", ".rw", "Rwanda", "Ruanda", "Ruanda", " Rwanda", "Ruanda", " Ruanda"));
            DomainFacade.set(new Country("SHN", "SH", ".sh", "Saint Helena", "St. Helena", "Santa Helena", " Sainte-Hélène (territoire)", "SantElena", " Santa Helena"));
            DomainFacade.set(new Country("KNA", "KN", ".kn", "Saint Kitts and Nevis", "St. Kitts und Nevis", "San Cristóbal y Nieves", " Saint-Christophe-et-Niévès", "Saint Kitts e Nevis", " São Cristóvão e Névis"));
            DomainFacade.set(new Country("AIA", "AI", ".ai", "Anguilla", "Anguilla", "Anguila", " Anguilla", "Anguilla", " Anguilla"));
            DomainFacade.set(new Country("LCA", "LC", ".lc", "Saint Lucia", "St. Lucia", "Santa Lucía", " Sainte-Lucie", "Santa Lucia", " Santa Lúcia"));
            DomainFacade.set(new Country("SPM", "PM", ".pm", "Saint Pierre and Miquelon", "Saint-Pierre und Miquelon", "San Pedro y Miquelón", " Saint-Pierre-et-Miquelon", "Saint Pierre e Miquelon", " Saint Pierre et Miquelon"));
            DomainFacade.set(new Country("VCT", "VC", ".vc", "Saint Vincent and the Grenadines", "St. Vincent und die Grenadinen", "San Vicente y las Granadinas", " Saint-Vincent-et-les Grenadines", "Saint Vincent e Grenadine", " São Vicente e Granadinas"));
            DomainFacade.set(new Country("SMR", "SM", ".sm", "San Marino", "San Marino", "San Marino", " Saint-Marin", "San Marino", " San Marino"));
            DomainFacade.set(new Country("STP", "ST", ".st", "Sao Tome and Principe", "São Tomé und Príncipe", "Santo Tomé y Príncipe", " Sao Tome-et-Principe !São Tomé-et-Principe", "Sao Tome e Principe", " São Tomé e Príncipe"));
            DomainFacade.set(new Country("SAU", "SA", ".sa", "Saudi Arabia", "Saudi-Arabien", "Arabia Saudita", " Arabie saoudite", "Arabia Saudita", " Arábia Saudita"));
            DomainFacade.set(new Country("SEN", "SN", ".sn", "Senegal", "Senegal", "Senegal", " Senegal !Sénégal", "Senegal", " Senegal"));
            DomainFacade.set(new Country("SRB", "RS", ".rs", "Serbia", "Serbien", "Serbia", " Serbie", "Serbia[1]", " Sérvia"));
            DomainFacade.set(new Country("SYC", "SC", ".sc", "Seychelles", "Seychellen", "Seychelles", " Seychelles", "Seychelles", " Seychelles"));
            DomainFacade.set(new Country("SLE", "SL", ".sl", "Sierra Leone", "Sierra Leone", "Sierra Leona", " Sierra Leone", "Sierra Leone", " Serra Leoa"));
            DomainFacade.set(new Country("SGP", "SG", ".sg", "Singapore", "Singapur", "Singapur", " Singapour", "Singapore", " Singapura"));
            DomainFacade.set(new Country("SVK", "SK", ".sk", "Slovakia", "Slowakei", "Eslovaquia", " Slovaquie", "Slovacchia", " Eslováquia"));
            DomainFacade.set(new Country("VNM", "VN", ".vn", "Viet Nam", "Vietnam", "Vietnam", " Viêt Nam", "Vietnam", " Vietname"));
            DomainFacade.set(new Country("SVN", "SI", ".si", "Slovenia", "Slowenien", "Eslovenia", " Slovenie !Slovénie", "Slovenia", " Eslovénia"));
            DomainFacade.set(new Country("SOM", "SO", ".so", "Somalia", "Somalia", "Somalia", " Somalie", "Somalia", " Somália"));
            DomainFacade.set(new Country("ZAF", "ZA", ".za", "South Africa", "Südafrika", "Sudáfrica", " Afrique du Sud", "Sudafrica", " África do Sul"));
            DomainFacade.set(new Country("ZWE", "ZW", ".zw", "Zimbabwe", "Simbabwe", "Zimbabue", " Zimbabwe", "Zimbabwe", " Zimbabwe"));
            DomainFacade.set(new Country("ESP", "ES", ".es", "Spain", "Spanien", "España(Ceuta y Melilla)", " Espagne", "Spagna", " Espanha"));
            DomainFacade.set(new Country("ESH", "EH", ".eh", "Western Sahara", "Westsahara", "Sahara Occidental", " Sahara occidental", "Sahara Occidentale", " Saara Ocidental"));
            DomainFacade.set(new Country("SDN", "SD", ".sd", "Sudan", "Sudan", "Sudán", " Soudan", "Sudan", " Sudão"));
            DomainFacade.set(new Country("SUR", "SR", ".sr", "Suriname", "Suriname", "Surinam", " Suriname", "Suriname", " Suriname"));
            DomainFacade.set(new Country("SJM", "SJ", ".sj", "Svalbard and Jan Mayen", "Svalbard und Jan Mayen", "Svalbard y Jan Mayen", " Svalbard et ile Jan Mayen !Svalbard et île Jan Mayen", "Svalbard e Jan Mayen", " Svalbard e Jan Mayen"));
            DomainFacade.set(new Country("SWZ", "SZ", ".sz", "Swaziland", "Swasiland", "Suazilandia", " Swaziland", "Swaziland", " Suazilândia"));
            DomainFacade.set(new Country("SWE", "SE", ".se", "Sweden", "Schweden", "Suecia", " Suede !Suède", "Svezia", " Suécia"));
            DomainFacade.set(new Country("CHE", "CH", ".ch", "Switzerland", "Schweiz", "Suiza", " Suisse", "Svizzera", " Suíça"));
            DomainFacade.set(new Country("SYR", "SY", ".sy", "Syrian Arab Republic", "Syrien", "Siria", " Syrie", "Siria", " Síria"));
            DomainFacade.set(new Country("TJK", "TJ", ".tj", "Tajikistan", "Tadschikistan", "Tayikistán", " Tadjikistan", "Tagikistan", " Tajiquistão"));
            DomainFacade.set(new Country("THA", "TH", ".th", "Thailand", "Thailand", "Tailandia", " Thaïlande", "Thailandia", " Tailândia"));
            DomainFacade.set(new Country("TGO", "TG", ".tg", "Togo", "Togo", "Togo", " Togo", "Togo", " Togo"));
            DomainFacade.set(new Country("TKL", "TK", ".tk", "Tokelau", "Tokelau", "Tokelau", " Tokelau", "Tokelau", " Toquelau"));
            DomainFacade.set(new Country("TON", "TO", ".to", "Tonga", "Tonga", "Tonga", " Tonga", "Tonga", " Tonga"));
            DomainFacade.set(new Country("TTO", "TT", ".tt", "Trinidad and Tobago", "Trinidad und Tobago", "Trinidad y Tobago", " Trinité-et-Tobago", "Trinidad e Tobago", " Trindade e Tobago"));
            DomainFacade.set(new Country("ARE", "AE", ".ae", "United Arab Emirates", "Vereinigte Arabische Emirate", "Emiratos Árabes Unidos", " Emirats arabes unis !Émirats arabes unis", "Emirati Arabi Uniti", " Emiratos Árabes Unidos"));
            DomainFacade.set(new Country("TUN", "TN", ".tn", "Tunisia", "Tunesien", "Túnez", " Tunisie", "Tunisia", " Tunísia"));
            DomainFacade.set(new Country("TUR", "TR", ".tr", "Turkey", "Türkei", "Turquía", " Turquie", "Turchia", " Turquia"));
            DomainFacade.set(new Country("TKM", "TM", ".tm", "Turkmenistan", "Turkmenistan", "Turkmenistán", " Turkménistan", "Turkmenistan", " Turquemenistão"));
            DomainFacade.set(new Country("TCA", "TC", ".tc", "Turks and Caicos Islands", "Turks- und Caicosinseln", "Islas Turcas y Caicos", " Iles Turques et Caiques !Îles Turques et Caïques", "Isole Turks e Caicos", " Turks e Caicos"));
            DomainFacade.set(new Country("TUV", "TV", ".tv", "Tuvalu", "Tuvalu", "Tuvalu", " Tuvalu", "Tuvalu", " Tuvalu"));
            DomainFacade.set(new Country("UGA", "UG", ".ug", "Uganda", "Uganda", "Uganda", " Ouganda", "Uganda", " Uganda"));
            DomainFacade.set(new Country("UKR", "UA", ".ua", "Ukraine", "Ukraine", "Ucrania", " Ukraine", "Ucraina", " Ucrânia"));
            DomainFacade.set(new Country("MKD", "MK", ".mk", "Macedonia, the former Yugoslav Republic of", "Mazedonien", "ARY Macedonia", " Macédoine (pays)", "Macedonia", " República da Macedónia"));
            DomainFacade.set(new Country("EGY", "EG", ".eg", "Egypt", "Ägypten", "Egipto", " Egypte !Égypte", "Egitto", " Egipto"));
            DomainFacade.set(new Country("GBR", "GB", ".uk", "United Kingdom", "Vereinigtes Königreich Großbritannien und Nordirland", "Reino Unido", " Royaume-Uni", "Regno Unito", " Reino Unido"));
            DomainFacade.set(new Country("GGY", "GG", ".gg", "Guernsey", "Guernsey (Kanalinsel)", "Guernsey", " Guernesey", "Guernsey", " Guernsey"));
            DomainFacade.set(new Country("JEY", "JE", ".je", "Jersey", "Jersey (Kanalinsel)", "Jersey", " Jersey", "Jersey", " Jersey"));
            DomainFacade.set(new Country("IMN", "IM", ".im", "Isle of Man", "Insel Man", "Isla de Man", " Ile de Man !Île de Man", "Isola di Man", " Ilha de Man"));
            DomainFacade.set(new Country("TZA", "TZ", ".tz", "Tanzania, United Republic of", "Tansania", "Tanzania", " Tanzanie", "Tanzania", " Tanzânia"));
            DomainFacade.set(new Country("USA", "US", ".us", "United States", "Vereinigte Staaten von Amerika", "Estados Unidos", " Etats-Unis !États-Unis", "Stati Uniti dAmerica", " Estados Unidos da América"));
            DomainFacade.set(new Country("VIR", "VI", ".vi", "Virgin Islands, U.S.", "Amerikanische Jungferninseln", "Islas Vírgenes Estadounidenses", " Iles Vierges americaines !Îles Vierges américaines", "Isole Vergini Americane", " Ilhas Virgens Americanas"));
            DomainFacade.set(new Country("BFA", "BF", ".bf", "Burkina Faso", "Burkina Faso", "Burkina Faso", " Burkina Faso", "Burkina Faso", " Burkina Faso"));
            DomainFacade.set(new Country("URY", "UY", ".uy", "Uruguay", "Uruguay", "Uruguay", " Uruguay", "Uruguay", " Uruguai"));
            DomainFacade.set(new Country("UZB", "UZ", ".uz", "Uzbekistan", "Usbekistan", "Uzbekistán", " Ouzbekistan !Ouzbékistan", "Uzbekistan", " Usbequistão"));
            DomainFacade.set(new Country("VEN", "VE", ".ve", "Venezuela", "Venezuela", "Venezuela", " Venezuela", "Venezuela", " Venezuela"));
            DomainFacade.set(new Country("WLF", "WF", ".wf", "Wallis and Futuna", "Wallis und Futuna", "Wallis y Futuna", " Wallis-et-Futuna", "Wallis e Futuna", " Wallis e Futuna"));
            DomainFacade.set(new Country("WSM", "WS", ".ws", "Samoa", "Samoa", "Samoa", " Samoa", "Samoa", " Samoa (Samoa Ocidental)"));
            DomainFacade.set(new Country("YEM", "YE", ".ye", "Yemen", "Jemen", "Yemen", " Yémen", "Yemen", " Iémen"));
            DomainFacade.set(new Country("ZMB", "ZM", ".zm", "Zambia", "Sambia", "Zambia", " Zambie", "Zambia", " Zâmbia"));
        }
        catch (CouldNotSaveException ex)
        {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void restorePlayer()
    {
        for (int i = 0; i < 1000; i++)
        {
            try
            {
                Country country = DomainFacade.getByName(Country.class, "Togo");
                IAddress address = new Address("Street" + i, i, "Village" + i, 6500 + i, country);
                int day = new Random().nextInt(28);
                int month = new Random().nextInt(12);
                int year = new Random().nextInt(90);

                Date dateOfBirth = DateFormat.getDateInstance().parse(day + "/" + month + "/" + year + " 4:5 PM, PDT");
                Date memberFrom = DateFormat.getDateInstance().parse(day + "/" + month + "/" + (year + 7) + " 4:5 PM, PDT");
                String telephoneNumber = "+43/" + new Random().nextInt();
                String emailAddress = new Random().nextInt(100000) + "@sample.com";

                List<ITypeOfSport> list = new LinkedList<>();
                list.add(DomainFacade.getByName(ITypeOfSport.class, "Volleyball"));

                List<IRole> roles = new LinkedList<>();
                roles.add(DomainFacade.getByName(IRole.class, "Player"));

                IMember member = new Member();
                member.setPrename("Prename" + i);
                member.setLastname("Lastname" + i);
                member.setAddress(address);
                member.setDateOfBirth(dateOfBirth);
                member.setMemberFrom(memberFrom);
                member.setTelephonenumber(telephoneNumber);
                member.setEmailAddress(emailAddress);
                member.setGender(i % 2 == 0);
                member.setRoleList(roles);
                member.setNationality(country);

                DomainFacade.set(member);
            }
            catch (CouldNotSaveException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (ParseException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void restoreTrainer()
    {
        for (int i = 0; i < 100; i++)
        {
            try
            {
                Country country = DomainFacade.getByName(Country.class, "Togo");
                IAddress address = new Address("Street" + i, i, "Village" + i, 6500 + i, country);
                int day = new Random().nextInt(28);
                int month = new Random().nextInt(12);
                int year = new Random().nextInt(90);

                Date dateOfBirth = DateFormat.getDateInstance().parse(day + "/" + month + "/" + year + " 4:5 PM, PDT");
                Date memberFrom = DateFormat.getDateInstance().parse(day + "/" + month + "/" + (year + 7) + " 4:5 PM, PDT");
                String telephoneNumber = "+43/" + new Random().nextInt();
                String emailAddress = new Random().nextInt(100000) + "@sample.com";

                List<IRole> roles = new LinkedList<>();
                roles.add(DomainFacade.getByName(IRole.class, "Trainer"));

                IMember member = new Member();
                member.setPrename("PrenameTrainer" + i);
                member.setLastname("LastnameTrainer" + i);
                member.setAddress(address);
                member.setDateOfBirth(dateOfBirth);
                member.setMemberFrom(memberFrom);
                member.setTelephonenumber(telephoneNumber);
                member.setEmailAddress(emailAddress);
                member.setGender(i % 2 == 0);
                member.setRoleList(roles);
                member.setNationality(country);

                DomainFacade.set(member);
            }
            catch (CouldNotSaveException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (ParseException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void restoreClubTeams()
    {
        for (int i = 0; i < 10; i++)
        {
            List<IPlayer> players = new LinkedList<>();

            try
            {
                for (int j = 0; j < 20; j++)
                {
                    IPlayer m = DomainFacade.getByName(IPlayer.class, "Prename" + (i * 10 + j));
                    players.add(m);
                }

                League league = DomainFacade.getByName(League.class, "League" + i);


                IClubTeam team = new ClubTeam();
                team.setName("Team" + i);
                team.setDescription("Description for Team " + i);
                team.setLeague(league);
                team.setPlayerList(players);
                DomainFacade.set(team);

                DomainFacade.set(team);

            }
            catch (CouldNotSaveException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void restoreTeams()
    {
        for (int i = 0; i < 10; i++)
        {
            League league = DomainFacade.getByName(League.class, "League" + i);

            for (int j = 0; j < 19; j++)
            {
                try
                {
                    ITeam team = new Team();
                    team.setName("Foreign Team" + (i * 10 + j));
                    team.setDescription("Description for foreign Team " + (i * 10 + j));
                    team.setLeague(league);
                    DomainFacade.set(team);
                }
                catch (CouldNotSaveException ex)
                {
                    Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private static void restoreDepartmentHead()
    {
        for (int i = 0; i < 100; i++)
        {
            try
            {
                Country country = DomainFacade.getByName(Country.class, "Togo");
                IAddress address = new Address("Street" + i, i, "Village" + i, 6500 + i, country);

                int day = new Random().nextInt(28);
                int month = new Random().nextInt(12);
                int year = new Random().nextInt(90);

                Date dateOfBirth = DateFormat.getDateInstance().parse(day + "/" + month + "/" + year + " 4:5 PM, PDT");
                Date memberFrom = DateFormat.getDateInstance().parse(day + "/" + month + "/" + (year + 7) + " 4:5 PM, PDT");
                String telephoneNumber = "+43/" + new Random().nextInt();
                String emailAddress = new Random().nextInt(100000) + "@sample.com";

                List<IRole> roles = new LinkedList<>();
                roles.add(DomainFacade.getByName(Role.class, "DepartmentHead"));

                IMember member = new Member();
                member.setPrename("PrenameDepartmentHead" + i);
                member.setLastname("LastnameDepartmentHead" + i);
                member.setAddress(address);
                member.setDateOfBirth(dateOfBirth);
                member.setMemberFrom(memberFrom);
                member.setTelephonenumber(telephoneNumber);
                member.setEmailAddress(emailAddress);
                member.setGender(i % 2 == 0);
                member.setRoleList(roles);
                member.setNationality(country);

                DomainFacade.set(member);
            }
            catch (CouldNotSaveException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (ParseException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void restoreDepartment()
    {
        try
        {
            DomainFacade.set(new Department("Basketball", "", DomainFacade.getByName(ITypeOfSport.class, "Basketball")));
            DomainFacade.set(new Department("Baseball", "", DomainFacade.getByName(ITypeOfSport.class, "Baseball")));
            DomainFacade.set(new Department("American Football", "", DomainFacade.getByName(ITypeOfSport.class, "American Football"), DomainFacade.getByName(TypeOfSport.class, "Rugby")));
            DomainFacade.set(new Department("Football", "", DomainFacade.getByName(ITypeOfSport.class, "Football")));
            DomainFacade.set(new Department("Cricket", "", DomainFacade.getByName(ITypeOfSport.class, "Cricket")));
            DomainFacade.set(new Department("Hockey", "", DomainFacade.getByName(ITypeOfSport.class, "Hockey"), DomainFacade.getByName(TypeOfSport.class, "Ice Hockey")));
            DomainFacade.set(new Department("Curling", "", DomainFacade.getByName(ITypeOfSport.class, "Curling")));
            DomainFacade.set(new Department("Fistball", "", DomainFacade.getByName(ITypeOfSport.class, "Fistball")));
            DomainFacade.set(new Department("Volleyball", "", DomainFacade.getByName(ITypeOfSport.class, "Volleyball"), DomainFacade.getByName(TypeOfSport.class, "Beachvolleyball")));
        }
        catch (CouldNotSaveException ex)
        {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void restoreCompetitions()
    {
        for (int i = 1; i <= 10; i++)
        {
            try
            {
                List<ITeam> teams = new LinkedList<>();

                teams.add(DomainFacade.getByName(ITeam.class, "Team" + i));

                for (int j = 0; j < 19; j++)
                {
                    teams.add(DomainFacade.getByName(ITeam.class, "Foreign Team" + j));
                }

                Date dateFrom = DateFormat.getDateInstance().parse(i + "/12/112 4:5 PM, PDT");
                Date dateTo = DateFormat.getDateInstance().parse((i + 2) + "/12/112 4:5 PM, PDT");

                Competition c = new Competition();

                c.setTeamList(teams);

                for (ITeam team : teams)
                {
                    for (ITeam otherTeam : teams)
                    {
                        if (otherTeam.equals(team))
                        {
                            continue;
                        }

                        IMatch match = new Match();
                        match.setHometeam(team);
                        match.setForeignteam(otherTeam);
                        match.setDateFrom(dateFrom);
                        match.setDateTo(dateTo);
                        match.setCompetition(c);

                        DomainFacade.set(match);
                    }
                }

                DomainFacade.set(c);
            }
            catch (CouldNotSaveException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (ParseException ex)
            {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
