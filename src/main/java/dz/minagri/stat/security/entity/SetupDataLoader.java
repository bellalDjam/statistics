package dz.minagri.stat.security.entity;

import dz.minagri.stat.customer.entity.CarteFellah;
import dz.minagri.stat.customer.entity.Exploitant;
import dz.minagri.stat.customer.enumeration.ExploitStatus;
import dz.minagri.stat.customer.enumeration.ExploitantStatus;
import dz.minagri.stat.customer.enumeration.Gender;
import dz.minagri.stat.customer.repository.CarteFellahRepository;
import dz.minagri.stat.customer.repository.ExploitantRepository;
import dz.minagri.stat.customer.service.CarteFellahService;
import dz.minagri.stat.location.entity.*;
import dz.minagri.stat.location.enumeration.TypeCommune;
import dz.minagri.stat.location.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final int DIGIT_COUNT = 12;
    private static final String cames[] = new String[]{"Biskra", "Oumache", "Branis", "Chetma", "Ouled Djellal", "Ras El Miaad", "Besbes", "Sidi Khaled",
            "Doucen", "Ech Chaïba", "Sidi Okba", "M'Chouneche", "El Haouch", "Aïn Naga", "Zeribet El Oued", "El Feidh", "El Kantara",
            "Aïn Zaatout", "El Outaya", "Djemorah", "Tolga", "Lioua", "Lichana", "Ourlal", "M'Lili", "Foughala", "Bordj Ben Azzouz", "El Mizaraa", "Bouchagroune"
            , "Mekhadma", "El Ghrous", "El Hadjeb", "Khenguet Sidi Nadji"
    };
    private static final String supwil[] = new String[]{"439700", "4795", "25057", "6783", "12192", "3268", "20986", "162200"
            , "1575", "4439", "556185", "14227", "9061", "20673", "3568", "1190", "66415", "2577", "6504", "6764", "4026", "9096", "1439"
            , "4101", "2187", "8866", "2175", "18718", "5941", "211980", "2121", "78870", "285000", "4115", "1356", "3339", "159000"
            , "3152", "54573", "9811", "4541", "1605", "9373", "4891", "29950", "2379", "86105", "4870"
    };
    private static final String cwil[] = new String[]{"ADRAR", "CHLEF", "LAGHOUAT", "OUM EL BOUAGHI", "BATNA", "BEJAIA", "BISKRA", "BECHAR",
            "BLIDA", "BOUIRA", "TAMANRASSET", "TEBESSA", "TLEMCEN", "TIARET", "TIZI OUZOU", "ALGER", "DJELFA", "JIJEL",
            "SETIF", "SAIDA", "SKIKDA", "SIDI BEL ABBES", "ANNABA", "GUELMA", "CONSTANTINE", "MEDEA", "MOSTAGANEM", "M’SILA", "MASCARA", "OUARGLA"
            , "ORAN", "EL BAYADH", "ILLIZI", "BORDJ BOU ARRERIDJ", "BOUMERDES", "EL TARF", "TINDOUF", "TISSEMSILT", "EL OUED", "KHENCHELA"
            , "SOUK AHRAS", "TIPAZA", "MILA", "AIN DEFLA", "NAAMA", "AIN TEMOUCHENT", "GHARDAIA", "RELIZANE"
    };
    /**
     * private static final String codWil[] = new String[]{
     * "100","200","300","400","500","600","800","900","1000","1100","1200","1300","1400","1500","1700","1800","1900","2000","2100","2200","2300","2400","2500","2600","2700","2800","2900","3000","3100","3200","3300","3400","3500","3600","3700","3800","3900","4000","4100","4200","4300","4400","4500","4600","4700","4800","700","1600"
     * };
     */
    private static final String comAl[] = new String[]{"Alger-Centre", "Sidi M'Hamed", "El Madania", "Belouizdad", "Bab El Oued", "Bologhine", "Casbah",
            "Oued Koriche", "Bir Mourad Raïs", "El Biar", "Bouzareah", "Birkhadem", "El Harrach", "Baraki", "Oued Smar", "Bachdjerrah", "Hussein Dey", "Kouba"
            , "Bourouba", "Dar El Beïda", "Bab Ezzouar", "Ben Aknoun", "Dely Ibrahim", "El Hammamet", "Raïs Hamidou", "Djasr Kasentina", "El Mouradia", "Hydra"
            , "Mohammadia", "Bordj El Kiffan", "El Magharia", "Beni Messous", "Les Eucalyptus", "Birtouta", "Tessala El Merdja", "Ouled Chebel", "Sidi Moussa"
            , "Aïn Taya", "Bordj El Bahri", "El Marsa", "H'Raoua", "Rouïba", "Reghaïa", "Aïn Benian", "Staoueli", "Zeralda", "Mahelma", "Rahmania", "Souidania"
            , "Cheraga", "Ouled Fayet", "El Achour", "Draria", "Douera", "Baba Hassen", "Khraicia", "Saoula"
    };
    private static final String mll[] = new String[]{
            "Zaouya Benouaar", "Mnahla", "Zaouya-Ouled-Moussa", "Sahra",
            "Essareg", "zerzara", "Elkodya", "Zommitta"
    };
    private static final String orl[] = new String[]{
            "Zao", "Mla", "Zaod-Moa", "Sara",
            "Ereg", "zara", "Elkp", "popmpu"
    };
    private static final String espcul[] = new String[]{"BLEDURE", "BLETENDRE", "ORGE", "AVOINE", "TRITICALE", "MAIS", "SORGHO", "FEVESFEVEROLLE"
            , "POIS", "LENTILLE", "POISCHICHE", "HARICOT", "GESSESGUERFALLA", "TREFLE", "PDT-MULTIPLICATION", "VESCE", "LUSERNE", "TOMATES-INDUSTR"
            , "TABAC", "ARACHIDE", "MENTHE", "PDT-CONSOMMATION", "PATATE-DOUCE", "CARROTE", "TOMATE-PLCHAMP", "TOMATE-SERRES", "OIGNON", "MELON",
            "MELON-D'EAU", "CANTALOUP", "PASTEQUE", "ARTICHAUT", "PIMENT", "POIVRON", "CONCOMBRE", "COURGETTE", "AUBERGINE", "CHOUXVERT", "CHOUXFLEUR"
            , "NAVET", "AIL", "PETITSPOIS", "FENOUIL", "SALAD", "BETRAVE", "FRAISE", "CELERIE", "CITROULLE", "PERCILE", "EPINARD"
    };
    // @Autowired
    //private PasswordEncoder passwordEncoder;
    // API
    LocalDate presentDate = LocalDate.now();
    DateTimeFormatter dateFormatter
            = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    private boolean alreadySetup = false;
    @Autowired
    private ZoneRepository zRepo;
    @Autowired
    private CarteFellahRepository cfRepo;
    @Autowired
    private CarteFellahService carteFellahService;
    @Autowired
    private WilayaRepository wRepo;
    @Autowired
    private CommuneRepository cRepo;
    @Autowired
    private AddressRepository adRepo;
    @Autowired
    private ExploitantRepository exploitatRepo;
    @Autowired
    private ExploitRepository exploitRepo;
    @Autowired
    private ExploitationRepository expltionRepo;
    @PersistenceContext
    private EntityManager entityManager;

    public static String generateUniqueId() {
        long timestamp = System.nanoTime();
        String uniqueId = String.valueOf(timestamp);

        // Ensure the unique ID has the desired 12-digit length
        if (uniqueId.length() < DIGIT_COUNT) {
            uniqueId = String.format("%0" + DIGIT_COUNT + "d", timestamp);
        } else if (uniqueId.length() > DIGIT_COUNT) {
            uniqueId = uniqueId.substring(0, DIGIT_COUNT);
        }

        return uniqueId;
    }

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial user
        // createUserIfNotFound("test@test.com", "admin", "admin", "admin", "admin");

        // == create initial user technician
        //   createUserIfNotFound("user@user1.com", "user1", "user1", "user1", "admin");


        createZones();
        //  createAddress();
        createFellah();
        createExploitant();
        createExploitation();
        LinkExpoit();
        linkFellahExploitant();
        alreadySetup = true;
    }

    /*  @Transactional
      User createUserIfNotFound(final String email, final String userName, final String firstName, final String lastName, final String password) {
          User user = userRepository.findByEmail(email);
          if (user == null) {
              user = new User();
              user.setFirstName(firstName);
              user.setLastName(lastName);
              user.setUserName(userName);
              user.setPassword(passwordEncoder.encode(password));
              user.setEmail(email);
              user.setEnabled(true);
              user.setAvailable(true);
              user.setRegisterDate(LocalDate.now());
              user.setColor("#3f51b5");
          }
          user = userRepository.save(user);
          return user;
      }
  */
    @Transactional
    public void createZones() {

        for (int i = 0; i < cwil.length; i++) {
            Wilaya wil = new Wilaya();

            if (null == wRepo.findOneBynomWilaya(cwil[i])) {
                Long code = (long) (100 * i + 100);
                wil.setCodeWilaya(code);
                wil.setTotarea(Integer.parseInt(supwil[i]));
                wil.setNomWilaya(cwil[i]);
                wRepo.save(wil);
            }

        }

        /*Add Communes Biskra and save Communes
         **/
        Wilaya bis = wRepo.findOneBynomWilaya("BISKRA");
        for (int i = 0; i < cames.length; i++) {
            Long code = (long) (700 + i + 1);
            Commune com = new Commune();
            com.setCodeCommune(code);
            com.setWilaya(bis);
            com.setTypeCommune(TypeCommune.COMMUNAL);
            com.setName(cames[i]);
            bis.addCommune(com);
        }
        wRepo.save(bis);

        /*Add Communes Alger save Communes
         * **/
        Wilaya alg = wRepo.findOneBynomWilaya("ALGER");
        for (int i = 0; i < comAl.length; i++) {
            Long code = (long) (1600 + i + 1);
            Commune com = new Commune();
            com.setCodeCommune(code);
            com.setWilaya(alg);
            com.setTypeCommune(TypeCommune.COMMUNAL);
            com.setName(comAl[i]);
            alg.addCommune(com);
        }
        wRepo.save(alg);

        Commune commlil = cRepo.findByName("M'Lili");
        for (int i = 0; i < mll.length; i++) {
            Zone zn = new Zone();
            zn.setName(mll[i]);
            zn.setCommune(commlil);
            commlil.addZone(zn);
        }
        cRepo.save(commlil);

        Commune commorl = cRepo.findByName("Ourlal");
        for (int i = 0; i < orl.length; i++) {
            Zone zn = new Zone();
            zn.setName(orl[i]);
            zn.setCommune(commorl);
            commorl.addZone(zn);
        }
        cRepo.save(commorl);
    }

    @Transactional
    public void createExpoitants() {

        for (int i = 0; i < cwil.length; i++) {
            Wilaya wil = new Wilaya();

            if (null == wRepo.findOneBynomWilaya(cwil[i])) {
                Long code = (long) (100 * i + 100);
                wil.setCodeWilaya(code);
                wil.setTotarea(Integer.parseInt(supwil[i]));
                wil.setNomWilaya(cwil[i]);
                wRepo.save(wil);
            }

        }

        /*Add Communes Biskra and save Communes
         **/
        Wilaya bis = wRepo.findOneBynomWilaya("BISKRA");
        for (int i = 0; i < cames.length; i++) {
            Long code = (long) (700 + i + 1);
            Commune com = new Commune();
            com.setCodeCommune(code);
            com.setWilaya(bis);
            com.setTypeCommune(TypeCommune.COMMUNAL);
            com.setName(cames[i]);
            bis.addCommune(com);
        }
        wRepo.save(bis);

        /*Add Communes Alger save Communes
         * **/
        Wilaya alg = wRepo.findOneBynomWilaya("ALGER");
        for (int i = 0; i < comAl.length; i++) {
            Long code = (long) (1600 + i + 1);
            Commune com = new Commune();
            com.setCodeCommune(code);
            com.setWilaya(alg);
            com.setTypeCommune(TypeCommune.COMMUNAL);
            com.setName(comAl[i]);
            alg.addCommune(com);
        }
        wRepo.save(alg);

        Commune commlil = cRepo.findByName("M'Lili");
        for (int i = 0; i < mll.length; i++) {
            Zone zn = new Zone();
            zn.setName(mll[i]);
            zn.setCommune(commlil);
            commlil.addZone(zn);
        }
        cRepo.save(commlil);

        Commune commorl = cRepo.findByName("Ourlal");
        for (int i = 0; i < orl.length; i++) {
            Zone zn = new Zone();
            zn.setName(orl[i]);
            zn.setCommune(commorl);
            commorl.addZone(zn);
        }
        cRepo.save(commorl);
    }

    public void createFellah() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < cwil.length; j++) {
                Wilaya wilaya = wRepo.findOneBynomWilaya(cwil[j]);
                String uniqueId = generateUniqueId();
                CarteFellah cfh = new CarteFellah();
                String s12 = java.security.SecureRandom.class.getName();
                cfh.setWilaya(wilaya);
                cfh.setNationalS12(uniqueId);
                cfh.setRegistrationDate(LocalDate.now());
                cfRepo.save(cfh);
            }
        }
    }

    public void createExploitant() {
        for (int j = 0; j < cwil.length; j++) {
            Exploitant exploitant = new Exploitant();
            exploitant.setBirthday(LocalDate.of(1981, 01, 01));
            exploitant.setExploitantStatus(ExploitantStatus.ACTIVE);
            exploitant.setGender(Gender.MR);
            exploitant.setFirstname("MASSAOUD" + j);
            exploitant.setLastname("MECHRY");
            exploitant.setRegistrationDate(LocalDate.now());
            exploitatRepo.save(exploitant);
        }
    }

    public void createExploitation() {
        for (int j = 0; j < cwil.length; j++) {
            Exploitation expltion = new Exploitation();
            expltion.setRegistrationDate(LocalDate.of(1981, 01, 01));
            expltion.setDescription("pretty one");
            expltion.setLieuDit("AlARJA");
            expltion.setZone(zRepo.findOneByName("Sahra"));
            expltion.setSurface("20024");
            expltion.setExpolitationName("Biladiii");
            expltionRepo.save(expltion);
        }
    }

    public void linkFellahExploitant() {

        for (int j = 3; j < (cwil.length) / 2; j++) {
            Random random = new Random();
            CarteFellah fellah = cfRepo.findOneById(Long.valueOf(j));

            //find a random exploitant
            Exploitant exploitant = exploitatRepo.findOneById(Long.valueOf(j + 2));
            String s12 = carteFellahService.findS12ByCarteFellahId(Long.valueOf(j));

            exploitant.setCarteFellah(fellah);
            exploitant.setNumS12(fellah.getNationalS12());
            exploitatRepo.save(exploitant);


        }
    }

    public void LinkExpoit() {
        ExploitStatus[] exploitStatus = ExploitStatus.values();
        Random random = new Random();
        expltionRepo.findAll()
                .forEach(extt -> {
                    for (int i = 0; i < 3; i++) {
                        int randomexploitant = random.nextInt(cwil.length);
                        Long randoexploit = Long.valueOf(randomexploitant);
                        Exploitant exploiant = exploitatRepo.findOneById(randoexploit);

                        System.out.println("Value is///////////////////////////////////: " + exploitatRepo.findOneById(randoexploit));

                        int indexStatus = random.nextInt(exploitStatus.length);
                        Exploit exploit = Exploit
                                .builder()
                                .exploitStatus(exploitStatus[indexStatus])
                                .activitiesStartDate(LocalDate.now().minusYears(indexStatus))
                                .activitiesEndDate(LocalDate.now().minusMonths(indexStatus))
                                .registrationDate(LocalDate.now().minusYears(indexStatus))
                                .exploitant(exploiant)
                                .exploitation(extt)
                                .build();
                        exploitRepo.save(exploit);

                    }
                });
    }
}
