/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.controller;

/**
 *
 * @author Brain
 */
public interface IAction {
    public boolean saveData() throws Exception;
    public boolean deleteData() throws Exception;
}
