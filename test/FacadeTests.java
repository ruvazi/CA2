/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import control.ControlCRUD;
import entity.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.persistence.*;

/**
 *
 * @author Home
 */
public class FacadeTests {
    ControlCRUD ctrl = new ControlCRUD();
    public FacadeTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void findPersonByPhone() {
    Person p = ctrl.getPerson(49283753);
    assertEquals("Jens",p.getFirstname());
    }
}
