///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.biolab.bean;
//
//import com.alexander.modelos.Cliente;
//import com.alexander.services.ClienteServices;
//import java.util.ArrayList;
//import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//import org.primefaces.event.CellEditEvent;
//import org.primefaces.event.RowEditEvent;
//
///**
// *
// * @author Victoria
// */
//@ManagedBean(name="clienteBean")
//@ViewScoped
//public class UsuarioBean {
//    private ArrayList<Cliente> clientes;    
//    private String filtro;
//    private String campo;
//    private Cliente filtroCliente;
//    private Cliente auxCli;
//    //servicios
//    ClienteServices clienteServices;
//
//    public Cliente getAuxCli() {
//        return auxCli;
//    }
//
//    public void setAuxCli(Cliente auxCli) {
//        this.auxCli = auxCli;
//    }
//     
//
//    public Cliente getFiltroCliente() {
//        return filtroCliente;
//    }
//
//    public void setFiltroCliente(Cliente filtroCliente) {
//        this.filtroCliente = filtroCliente;
//    }
//
//    public ClienteServices getClienteServices() {
//        return clienteServices;
//    }
//
//    public void setClienteServices(ClienteServices clienteServices) {
//        this.clienteServices = clienteServices;
//    }
//   
//    
//    @PostConstruct
//    public void iniciar(){      
//        //servicios        
//        clienteServices =new ClienteServices();
//        //inicializaciones        
//        clientes=(ArrayList<Cliente>)clienteServices.recuperarCliente();
//        filtro="nombre";
//        filtroCliente=new Cliente();
//        auxCli =new Cliente();
//        buscarFiltro();
//        
//    }
//    
//    public void buscarFiltro(){               
//        filtroCliente=new Cliente();
//        if(filtro.equals("nombre")){
//            filtroCliente.setNombre(campo);
//        }else{
//            filtroCliente.setRuc(campo);
//        }
//        clientes=(ArrayList<Cliente>)clienteServices.buscarFiltro(filtroCliente);
//    }
//    
//    public void resgitro(){
//        filtroCliente.setEstado('0');
//        clienteServices.registrarClient(filtroCliente);
//    }
//    
//    public ArrayList<Cliente> getClientes() {
//        return clientes;
//    }
//
//    public void setClientes(ArrayList<Cliente> clientes) {
//        this.clientes = clientes;
//    }
//
//    public String getFiltro() {
//        return filtro;
//    }
//
//    public void setFiltro(String filtro) {
//        this.filtro = filtro;
//    }
//
//    public String getCampo() {
//        return campo;
//    }
//
//    public void setCampo(String campo) {
//        this.campo = campo;
//    }
//    
//    public void onRowEdit(RowEditEvent event) {
//        auxCli=(Cliente)event.getObject();
//        FacesMessage msg = new FacesMessage("Cliente Editado", ((Cliente) event.getObject()).getIdCliente().toString());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//         clienteServices.modificarCliente(auxCli);
//    }
//     
//    public void onRowCancel(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Editado Cancelado", ((Cliente) event.getObject()).getIdCliente().toString());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
//     
//    public void onCellEdit(CellEditEvent event) {
//        Object oldValue = event.getOldValue();
//        Object newValue = event.getNewValue();
//         
//        if(newValue != null && !newValue.equals(oldValue)) {
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//           
//        }
//    }
//    
//}
