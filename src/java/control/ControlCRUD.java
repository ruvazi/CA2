package control;

import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import facade.Facade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ControlCRUD implements Facade {
    EntityManagerFactory EMF = Persistence.createEntityManagerFactory("CA-2-ORM-REST-AJAXPU");
    EntityManager EM = EMF.createEntityManager();

    @Override
    public Person getPerson(int phoneNumber) {
        Query q = EM.createNamedQuery("Person.findByPhone");
        q.setParameter("phonenum", phoneNumber);
        return (Person) q.getSingleResult();
    }

    @Override
    public List<Person> getPersonsByHobby(Hobby hobby) {
        Query q = EM.createNamedQuery("Person.findByHobby");
        q.setParameter("hobbyname", hobby.getHobbyname());
        return q.getResultList();
    }

    @Override
    public List<Person> getPersonsByCity(String zip) {
        Query q = EM.createNamedQuery("Person.findByCity");
        q.setParameter("zip", zip);
        return q.getResultList();
    }

    @Override
    public Company getCompanyByPhone(int phoneNumber) {
        Query q = EM.createNamedQuery("Company.findByPhone");
        q.setParameter("phonenum", phoneNumber);
        return (Company) q.getSingleResult();
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
