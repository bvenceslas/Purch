/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.models;

import brain.controller.IAction;
import java.sql.Date;

/**
 *
 * @author Brain
 */
public class ClsAchat implements IAction{
    private int id;
    private ClsClient _client;
    private Date _dateAchat;
    private ClsProduit _Produit;
    private ClsUser user;
    private float _qty, _reduction;

    public ClsAchat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClsClient getClient() {
        return _client;
    }

    public void setClient(ClsClient _client) {
        this._client = _client;
    }

    public Date getDateAchat() {
        return _dateAchat;
    }

    public void setDateAchat(Date _dateAchat) {
        this._dateAchat = _dateAchat;
    }

    public ClsProduit getProduit() {
        return _Produit;
    }

    public void setProduit(ClsProduit _Produit) {
        this._Produit = _Produit;
    }

    public float getQty() {
        return _qty;
    }

    public void setQty(float _qty) {
        this._qty = _qty;
    }

    public float getReduction() {
        return _reduction;
    }

    public void setReduction(float _reduction) {
        this._reduction = _reduction;
    }

    public ClsUser getUser() {
        return user;
    }

    public void setUser(ClsUser user) {
        this.user = user;
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
