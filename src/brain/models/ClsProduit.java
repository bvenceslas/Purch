/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.models;

import brain.controller.ClsUpdateModel;
import brain.controller.IAction;

/**
 *
 * @author Brain
 */
public class ClsProduit implements IAction{
    private int _id;
    private String _produit, _quantification;
    private float _prix, _stock;
    private ClsCategory _Category;

    public ClsProduit() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getProduit() {
        return _produit;
    }

    public void setProduit(String _produit) {
        this._produit = _produit;
    }

    public String getQuantification() {
        return _quantification;
    }

    public void setQuantification(String _quantification) {
        this._quantification = _quantification;
    }

    public float getPrix() {
        return _prix;
    }

    public void setPrix(float _prix) {
        this._prix = _prix;
    }

    public float getStock() {
        return _stock;
    }

    public void setStock(float _stock) {
        this._stock = _stock;
    }

    public ClsCategory getCategory() {
        return _Category;
    }

    public void setCategory(ClsCategory _Category) {
        this._Category = _Category;
    }

    @Override
    public boolean saveData() throws Exception {       
        return ClsUpdateModel.updateData(this);
    }

    @Override
    public boolean deleteData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
