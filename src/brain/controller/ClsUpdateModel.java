/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.controller;

import brain.models.ClsAccessSetup;
import brain.models.ClsCategory;
import brain.models.ClsClient;
import brain.models.ClsGamme;
import brain.models.ClsProvision;
import brain.models.ClsAchat;
import brain.models.ClsUser;
import brain.models.ClsPayment;
import brain.models.ClsProduit;
import brain.models.ClsFournisseur;
import brain.models.ClsQuantification;
import brain.models.ClsSoft;
import java.sql.PreparedStatement;

/**
 *
 * @author Brain
 */
public class ClsUpdateModel {

    public static boolean deleteData(String dbTable, int tbId) throws ClassNotFoundException, Exception{
        PreparedStatement ps = DbConnect.connectDb().prepareStatement("DELETE FROM "+dbTable+" WHERE id = ?");
            ps.setInt(1, tbId);
            ps.executeUpdate();
            ps.close();
            return true;
    }
    
    public static boolean updateData(Object obj) throws ClassNotFoundException, Exception{
        if (obj instanceof ClsAccessSetup) {
            ClsAccessSetup acset = (ClsAccessSetup)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_ACCESS_SETUP ?, ?");
            ps.setInt(1, acset.getId());
            ps.setString(2, acset.getAccessLevel());
            ps.executeUpdate();
            ps.close();
            return true;
            
        } else if (obj instanceof ClsCategory) {
            ClsCategory cat = (ClsCategory)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_CATEGORY ?, ?, ?");
            ps.setInt(1, cat.getId());
            ps.setString(2, cat.getCategory());
            ps.setString(3, cat.getGamme().getGamme());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsClient) {
            ClsClient cli = (ClsClient)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_CLIENT ?, ?, ?, ?");
            ps.setInt(1, cli.getId());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getPrenom());
            ps.setString(4, cli.getContact());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsGamme) {
            ClsGamme gam = (ClsGamme)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_GAMME ?, ?");
            ps.setInt(1, gam.getId());
            ps.setString(2, gam.getGamme());
            ps.executeUpdate();
            ps.close();
            return true;
        }else if (obj instanceof ClsProvision) {
            ClsProvision lineProv = (ClsProvision)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_LINE_PROVISION ?, ?, ?, ?, ?, ?");
            ps.setInt(1, lineProv.getId());
            ps.setString(2, lineProv.getFournisseur().getNom());
            ps.setDate(3, lineProv.getDateProvision());
            ps.setString(4, lineProv.getProduit().getProduit());
            ps.setFloat(5, lineProv.getQty());
            ps.setFloat(6, lineProv.getProduit().getPrix());
            ps.executeUpdate();
            ps.close();
            return true;
        }else if (obj instanceof ClsAchat) {
            ClsAchat lineAch = (ClsAchat)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_LINE_ACHAT ?, ?, ?, ?, ?, ?");
            ps.setInt(1, lineAch.getId());
            ps.setString(2, lineAch.getUser().getUsername());
            ps.setDate(3, lineAch.getDateAchat());
            ps.setString(4, lineAch.getProduit().getProduit());
            ps.setFloat(5, lineAch.getQty());
            ps.setFloat(6, lineAch.getReduction());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsUser) {
            ClsUser log = (ClsUser)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_USER ?, ?, ?");
            ps.setString(1, log.getUsername());
            ps.setString(2, log.getPwd());
            ps.setString(3, log.getAccessLevel());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsPayment) {
            ClsPayment pay = (ClsPayment)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_PAYMENT ?, ?, ?, ?, ?");
            ps.setInt(1, pay.getId());
            ps.setInt(2, pay.getAchat().getId());
            ps.setFloat(3, pay.getMontant());
            ps.setDate(4, pay.getDatePayment());
            ps.setString(5, pay.getUser().getUsername());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsProduit) {
            ClsProduit prod = (ClsProduit)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_PRODUIT ?, ?, ?, ?, ?, ?");
            ps.setInt(1, prod.getId());
            ps.setString(2, prod.getProduit());
            ps.setString(3, prod.getQuantification());
            ps.setFloat(4, prod.getPrix());
            ps.setFloat(5, prod.getStock());
            ps.setString(6, prod.getCategory().getCategory());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsFournisseur) {
            ClsFournisseur fourn = (ClsFournisseur)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_FOURNISSEUR ?, ?, ?, ?");
            ps.setInt(1, fourn.getId());
            ps.setString(2, fourn.getNom());
            ps.setString(3, fourn.getPrenom());
            ps.setString(4, fourn.getContact());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsQuantification) {
            ClsQuantification quant = (ClsQuantification)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_QUANTIFICATION ?, ?");
            ps.setInt(1, quant.getId());
            ps.setString(2, quant.getQuantification());
            ps.executeUpdate();
            ps.close();
            return true;
        } else if (obj instanceof ClsSoft) {
            ClsSoft soft = (ClsSoft)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_SOFT ?, ?");
            ps.setInt(1, soft.getId());
            ps.setString(2, soft.getSoft());
            ps.executeUpdate();
            ps.close();
            return true;
        }
        return false;
    
    }
}
