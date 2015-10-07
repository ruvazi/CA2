package control;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Infoentity;
import entity.Person;
import entity.Phone;
import facade.Facade;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ControlCRUD implements Facade {
    EntityManagerFactory EMF = Persistence.createEntityManagerFactory("CA-2-ORM-REST-AJAXPU");
    EntityManager EM = EMF.createEntityManager();

//    @Override
//    public Person getPerson(String phoneNumber) {
//        Query q = EM.createNamedQuery("Person.findByPhone",Person.class);
//        q.setParameter("phonenum", phoneNumber);
//        return (Person) q.getSingleResult();
//    }
    
    @Override
    public Person getPerson(String phoneNum){
        Query q = EM.createNamedQuery("Phone.findByPhonenum").setParameter("phonenum", phoneNum);
        System.out.println("PHONE NUMBER IS " + phoneNum);
        Phone ph = (Phone) q.getSingleResult();
        Infoentity ie = ph.getInfoentity();
        Collection cl = ie.getPersonCollection();
        Person p = (Person) cl.iterator().next();
        return p;
    }

//    @Override
//    public List<Person> getPersonsByHobby(Hobby hobby) {
//        Query q = EM.createNamedQuery("Person.findByHobby");
//        q.setParameter("hobbyname", hobby.getHobbyname());
//        return q.getResultList();
//    }
    
    @Override
    public List<Person> getPersonsByHobby(Hobby hobby) {
        Query q = EM.createNamedQuery("Hobby.findByHobbyname").setParameter("hobbyname", hobby.getHobbyname());
        List<Hobby> lh = q.getResultList();
        List <Person> l = new ArrayList();
        System.out.println(lh.iterator().next());
        for (Hobby h : lh){
            l.add(h.getPerson());
        }
        return l;
    }

    @Override
    public List<Person> getPersonsByCity(String zip) {
        Query q = EM.createNamedQuery("CityInfo.findByZipcode").setParameter("zipcode", zip);
        CityInfo ci = (CityInfo) q.getSingleResult();
        List<Address> la = (List<Address>) ci.getAddressCollection();
        List<Infoentity> lie = new ArrayList();
        for (Address a : la){
            lie.add(a.getInfoentity());
        }
        List<Person> lp = (List<Person>) lie.get(0).getPersonCollection();
        return lp;
    }

    @Override
    public Company getCompanyByPhone(String phoneNumber) {
        Query q = EM.createNamedQuery("Phone.findByPhonenum").setParameter("phonenum", phoneNumber);
        Phone p = (Phone) q.getSingleResult();
        Infoentity ie = p.getInfoentity();
        List<Company> cc = (List<Company>) ie.getCompanyCollection();
        Company c = cc.get(0);
        return c;
    }

    @Override
    public Company getCompanyByCVR(int cvr) {
       Query q = EM.createNamedQuery("Company.findByCvr");
       q.setParameter("cvr", cvr);
       return (Company) q.getSingleResult();
    }

    @Override
    public List<Company> getCompaniesByStaffCount(int staffMembers) {
        Query q = EM.createNamedQuery("Company.findByNumemployees");
        q.setParameter("numemployees", staffMembers);
        return q.getResultList();
    }

    @Override
    public int getHobbyCount(String hobby) {
        Query q = EM.createNamedQuery("Person.findByHobbyCount");
        q.setParameter("hobbyname", hobby);
        return (Integer) q.getSingleResult();
        
    }

    @Override
    public List<CityInfo> getZipcodes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createPerson() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createHobby() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createCompany() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePerson(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editPerson(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
