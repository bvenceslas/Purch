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
public class ClsUser implements IAction{
    private String _username, _pwd, _accessLevel;

    public ClsUser() {
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getPwd() {
        return _pwd;
    }

    public void setPwd(String _pwd) {
        this._pwd = _pwd;
    }

    public String getAccessLevel() {
        return _accessLevel;
    }

    public void setAccessLevel(String _accessLevel) {
        this._accessLevel = _accessLevel;
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
