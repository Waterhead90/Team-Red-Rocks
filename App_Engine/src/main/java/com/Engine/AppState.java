
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Engine;
import java.util.List;

/**
 *
 * @author mitchell.olson.1
 */
public interface AppState {
    public List<MenuItem> getListMenuItems();
    public void setListOfMenuItems(List<MenuItem> menuItems);
    public UserProfile getUserProfile();
    public void setUserProfile(UserProfile profile);
    public List<Venue> getListOfVenues();
    public void setListVenues(List<Venue> venues);
    public List<Recommendation> getRecommendationsList();
    public void setRecommendationsList(List<Recommendation> list);

    public Date getSystemTime();
    public void sortMenuItems();
    public void sortVenues();
    public void sortMeals();
    public void exportUserProfileTo(String filename);


}
