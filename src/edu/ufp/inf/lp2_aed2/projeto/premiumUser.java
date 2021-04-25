package edu.ufp.inf.lp2_aed2.projeto;

import java.util.ArrayList;
import java.util.Vector;

public class premiumUser extends User{
  public Date dateMembership;
  public int ownedPremCaches;

  public premiumUser(String nome, int idade, String local, Date inscricao, int ownedCaches, int id, ArrayList<Cache> myCache, Date dateMembership, int ownedPremCaches) {
    super(nome, idade, local, inscricao, ownedCaches, id, myCache);
    this.dateMembership = dateMembership;
    this.ownedPremCaches = ownedPremCaches;
  }

  public premiumUser(String nome, int idade, String local, Date inscricao, int id, ArrayList<Itens> myItens, int nItens, Date dateMembership) {
    super(nome, idade, local, inscricao, id, myItens, nItens);
    this.dateMembership = dateMembership;
  }

  public Date getDateMembership() {
    return dateMembership;
  }

  public void setDateMembership(Date dateMembership) {
    this.dateMembership = dateMembership;
  }

  public int getOwnedPremCaches() {
    return ownedPremCaches;
  }

  public void setOwnedPremCaches(int ownedPremCaches) {
    this.ownedPremCaches = ownedPremCaches;
  }

  public void listPmCaches(Cache c) {
  }

  public premiumUser findPmUser(int id) {
  return null;
  }

  public Date dateRemaining(Date end) {
  return null;
  }

}