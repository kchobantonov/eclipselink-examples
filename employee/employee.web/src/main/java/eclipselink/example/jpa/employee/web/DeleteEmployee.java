/*******************************************************************************
 * Copyright (c) 2010-2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *  dclarke - EclipseLink 2.3 - MySports Demo Bug 344608
 ******************************************************************************/
package eclipselink.example.jpa.employee.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import eclipselink.example.jpa.employee.model.Employee;


/**
 * Return list of available Leagues from JAX-RS call to MySports Admin app.
 * 
 * @author dclarke
 * @since EclipseLink 2.3.0
 */
@ManagedBean
@ViewScoped
public class DeleteEmployee {

    private Employee employee;

    private EntityManagerFactory emf;

    protected static final String PAGE = "/employee/delete?faces-redirect=true";

    public Employee getEmployee() {
        return employee;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    @PersistenceUnit(unitName = "employee")
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public String confirm() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        String idString = context.getRequestParameterMap().get("id");
        int id = Integer.valueOf(idString);

        System.out.println("CONFIRM DELETE EMPLOYEE: " + id);
        EntityManager em = getEmf().createEntityManager();
        try {
            this.employee = em.find(Employee.class, id);
            // TODO: Handle find failure
        } finally {
            em.close();
        }
        
        return PAGE;
    }
    
    public String delete() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        String idString = context.getRequestParameterMap().get("id");
        int id = Integer.valueOf(idString);

        System.out.println("DELETE EMPLOYEE: " + id);
        EntityManager em = getEmf().createEntityManager();
        try {
            this.employee = em.find(Employee.class, id);
            // TODO: Handle find failure
            em.getTransaction().begin();
            em.remove(getEmployee());
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
        return StreamEmployees.PAGE;
   }
    
    public String cancel() {
        return StreamEmployees.PAGE;
    }
}
