/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.models;

import brain.controller.IAction;

/**
 *
 * @author Brain
 */
public class ClsFournisseur implements IAction{
    private int _id;
    private String _nom, _prenom, _contact;

    public ClsFournisseur() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public String getPrenom() {
        return _prenom;
    }

    public void setPrenom(String _prenom) {
        this._prenom = _prenom;
    }

    public String getContact() {
        return _contact;
    }

    public void setContact(String _contact) {
        this._contact = _contact;
    }

    @Override
    public boolean saveData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}