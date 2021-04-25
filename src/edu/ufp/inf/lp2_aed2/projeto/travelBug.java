package edu.ufp.inf.lp2_aed2.projeto;

import java.util.ArrayList;
import java.lang.String;

public class travelBug extends Itens {
  public String mission;
  public boolean state;
  public User activeUser;
  public Cache activeCache;

  public travelBug(String nome, Date dateAdd, int itemID, Cache cache, String mission, boolean state, User activeUser, Cache activeCache) {
    super(nome, dateAdd, itemID, cache);
    this.mission = mission;
    this.state = state;
    this.activeUser = activeUser;
    this.activeCache = activeCache;
  }

  public travelBug(String nome, Date dateAdd, int itemID, User user, String mission, boolean state, User activeUser, Cache activeCache) {
    super(nome, dateAdd, itemID, user);
    this.mission = mission;
    this.state = state;
    this.activeUser = activeUser;
    this.activeCache = activeCache;
  }

  public String getMission() {
    return mission;
  }

  public void setMission(String mission) {
    this.mission = mission;
  }

  public boolean isState() {
    return state;
  }

  public void setState(boolean state) {
    this.state = state;
  }

  public User getActiveUser() {
    return activeUser;
  }

  public void setActiveUser(User activeUser) {
    this.activeUser = activeUser;
  }

  public Cache getActiveCache() {
    return activeCache;
  }

  public void setActiveCache(Cache activeCache) {
    this.activeCache = activeCache;
  }

  public boolean isMoving() {
  return false;
  }

  public travelBug addTB() {
  return null;
  }

  public travelBug removeTB() {
  return null;
  }

  public void now() {
  }

}