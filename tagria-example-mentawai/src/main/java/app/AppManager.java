package app;

import org.mentawai.core.ApplicationManager;
import org.mentawai.filter.MentaContainerFilter;

import action.AppAction;
import action.PersonAction;
import dao.PersonDao;

public class AppManager extends ApplicationManager {
	
    @Override
    public void loadActions() {
          
    	action("/App", AppAction.class,"welcome")
        .on(SUCCESS, fwd("/WEB-INF/jsp/app/welcome.jsp"));
    	
    	action("/Person", PersonAction.class, "list")
        .on(SUCCESS, fwd("/WEB-INF/jsp/person/list.jsp"));
  
        action("/Person", PersonAction.class, "form")
        .on(SUCCESS, fwd("/WEB-INF/jsp/person/form.jsp"));
        
        action("/Person", PersonAction.class, "edit")
        .on(SUCCESS, fwd("/WEB-INF/jsp/person/form.jsp"));
        
        action("/Person", PersonAction.class, "saveOrUpdate")
        .on(SUCCESS, redir("/Person.list.mtw"));
        
        action("/Person", PersonAction.class, "delete")
        .on(SUCCESS, redir("/Person.list.mtw"));
           
    }
    
    @Override
    public void loadFilters() {
    	 filter(new MentaContainerFilter());
    }
    
    @Override
    public void setupIoC() {
    	ioc(PersonDao.class,PersonDao.getInstance());
    }     
}