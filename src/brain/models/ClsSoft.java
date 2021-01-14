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
public class ClsSoft implements IAction{
    private int _id;
    private String _soft;

    public ClsSoft() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getSoft() {
        return _soft;
    }

    public void setSoft(String _soft) {
        this._soft = _soft;
    }

    @Override
    public boolean saveData() throws Exception {        
        return ClsUpdateModel.updateData(this);
    }

    @Override
    public boolean deleteData() throws Exception {
        return ClsUpdateModel.deleteData("", getId());
    }
    
}
