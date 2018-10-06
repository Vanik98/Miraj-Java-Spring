package miraj.pack.controller;

import miraj.pack.domain.Admin;
import miraj.pack.domain.Contacts;
import miraj.pack.domain.Reservation;
import miraj.pack.repos.AdminRepository;
import miraj.pack.repos.ContactsRepository;
import miraj.pack.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class PageController {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ContactsRepository contactsRepository;

    //index page
    @GetMapping("/")
    public String indexPage() {
        return "am/index_arm";
    }
    //en page
    @GetMapping("/en-home")
    public String homePage_en() {
        return "en/index";
    }
    @GetMapping(path = "/en-image")
    public String imagePage_en()
    {
        return "en/index-1";
    }
    @GetMapping(path = "/en-reservation")
    public String reservationPage_en() { return "en/index-2"; }
    @GetMapping(path = "/en-information")
    public String informationPage_en()
    {
        return "en/index-3";
    }
    @GetMapping(path = "/en-contacts")
    public String contactsPage_en()
    {
        return "en/index-4";
    }
    //am page
    @GetMapping("/am-home")
    public String homePage_am() {
        return "am/index_arm";
    }
    @GetMapping(path = "/am-image")
    public String imagePage_am()
    {
        return "am/index_arm-1";
    }
    @GetMapping(path = "/am-reservation")
    public String reservationPage_am() { return "am/index_arm-2"; }
    @GetMapping(path = "/am-information")
    public String informationPage_am()
    {
        return "am/index_arm-3";
    }
    @GetMapping(path = "/am-contacts")
    public String contactsPage_am()
    {
        return "am/index_arm-4";
    }
    //ru page
    @GetMapping("/ru-home")
    public String homePage_ru() {
        return "ru/index_rus";
    }
    @GetMapping(path = "/ru-image")
    public String imagePage_ru()
    {
        return "ru/index_rus-1";
    }
    @GetMapping(path = "/ru-reservation")
    public String reservationPage_ru() { return "ru/index_rus-2"; }
    @GetMapping(path = "/ru-information")
    public String informationPage_ru()
    {
        return "ru/index_rus-3";
    }
    @GetMapping(path = "/ru-contacts")
    public String contactsPage_ru()
    {
        return "ru/index_rus-4";
    }
    //login page
    @GetMapping(path = "/login")
    public String loginPage() { return "login"; }
    //////////////////

    public void pagerefresh(Map<String,Object> map)
    {
        int countcontact=0,countreserve=0;
        List list=(List) contactsRepository.findAll();
        if(list.size()!=0){
            for(int i=0;i<list.size();i++) {
                Contacts contacts= (Contacts) list.get(i);
                if (contacts.getReadd()== 1) {
                    countcontact++;
                }
            }}
        Admin a=new Admin(adminRepository.findById(1).get().getAdminid()-1+countcontact,
                adminRepository.findById(1).get().getLogin(),
                adminRepository.findById(1).get().getPassword());
        map.put("readmessage",a);
        if(list.size()!=0) {
            Contacts c = (Contacts) list.get(list.size() - 1);
            map.put("lastmessage",c);
        }
        List list2=(List) reservationRepository.findAll();
        if(list2.size()!=0){
            for(int i=0;i<list2.size();i++) {
                Reservation reservation= (Reservation) list2.get(i);
                if (reservation.getRread()== 1) {
                    countreserve++;
                }
            }}
        Admin a2=new Admin(adminRepository.findById(1).get().getAdminid()-1+countreserve,
                adminRepository.findById(1).get().getLogin(),
                adminRepository.findById(1).get().getPassword());
        map.put("readreserve",a2);

    }
    @GetMapping(path = "/admin")
    public String adminPage(Map<String,Object> map)
    {
        pagerefresh(map);
        return "admin";
    }
    ///////////////////////////////////////////////////////
    @PostMapping(path = "/reserve")
    public String reserve(@RequestParam String Name,
                         @RequestParam String Date,
                         @RequestParam String Lastname,
                         @RequestParam String Phone,
                         @RequestParam String Numberofpeople,
                         @RequestParam String pagereserve,
                         Map<String, Object> model) {
        Admin a=new Admin(adminRepository.findById(1).get().getAdminid(),
                adminRepository.findById(1).get().getLogin(),
                adminRepository.findById(1).get().getPassword());
        model.put("mytext",a);
        Reservation res = new Reservation(Name, Date, Lastname, Phone, Numberofpeople,1);
        reservationRepository.save(res);
        String page="";
        if(pagereserve.equals("en"))
            page="en/index-2";
        if(pagereserve.equals("am"))
            page="am/index_arm-2";
        if(pagereserve.equals("ru"))
            page="ru/index_rus-2";
        return page;
    }
    ///////////////////////////////////////////////////////
    @PostMapping(path = "/message")
    public String contacts(@RequestParam String Name2,
                           @RequestParam String email,
                           @RequestParam String Phone2,
                           @RequestParam String message,
                           @RequestParam String pagecontacts,
                           Map<String, Object> model) {
        Admin a=new Admin(adminRepository.findById(1).get().getAdminid(),
                adminRepository.findById(1).get().getLogin(),
                adminRepository.findById(1).get().getPassword());
        model.put("mytext2",a);
        Contacts contactssave=new Contacts(Name2,email,Phone2,message,1);
        contactsRepository.save(contactssave);
        String page="";
        if(pagecontacts.equals("en"))
            page="en/index-4";
        if(pagecontacts.equals("am"))
            page="am/index_arm-4";
        if(pagecontacts.equals("ru"))
            page="ru/index_rus-4";
        return page;

    }
    ///////////////////////////////////////////////////////
    @PostMapping(path = "/reservetable")
    public String adminreserve(Map<String, Object> map) {
        map.put("reserve", (List) reservationRepository.findAll());
        List list2=(List) reservationRepository.findAll();
        for (int i=0;i<list2.size();i++){
            Reservation reservation=(Reservation) list2.get(i);
            Reservation r=new Reservation(reservation.getId(),
                    reservation.getName(),
                    reservation.getDate(),
                    reservation.getLastname(),
                    reservation.getPhone(),
                    reservation.getNumberofpeople(),0);
            reservationRepository.save(r); }
            pagerefresh(map);
        return "admin";
    }
    ///////////////////////////////////////////////////////
    @PostMapping(path = "/messagetable")
    public String admincontacts(Map<String, Object> map) {
        map.put("message", (List) contactsRepository.findAll());
        List list=(List) contactsRepository.findAll();
        for (int i=0;i<list.size();i++){
            Contacts contacts= (Contacts) list.get(i);
            Contacts c=new Contacts(contacts.getId(),
                    contacts.getName(),
                    contacts.getEmail(),
                    contacts.getPhone(),
                    contacts.getSms(),0);
            contactsRepository.save(c); }
        pagerefresh(map);
        return "admin";
    }
    //////////////////////////////////////////////////////////////////////////////
    @PostMapping(path = "/deletemessage")
    public
    String deletemessage(@RequestParam int deletemessage,Map<String,Object> map) {
       Contacts cc = new Contacts(deletemessage);
        contactsRepository.delete(cc);
            pagerefresh(map);
        return "admin";
    }
    //////////////////////////////////////////////////////////////////////////////
    @PostMapping(path = "/deletereserve")
    public
    String deletereserve(@RequestParam int deletereserve,Map<String,Object> map) {
        Reservation rr = new Reservation(deletereserve);
        reservationRepository.delete(rr);
        pagerefresh(map);
        return "admin";
    }
}
