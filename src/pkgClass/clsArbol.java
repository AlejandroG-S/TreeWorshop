/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgClass;

/**
 *
 * @author Alejandro
 */
public class clsArbol {

    private clsNodo root;

    public clsArbol() {
        this.root = null;
    }

    public void insertar(clsNodo dato, clsNodo rootTmp) {
        if (this.getRoot() == null) {//Si el arbol está vacio
            this.setRoot(dato);

        } else {//El "arbol" no está vacio
            if (dato.getNum() > rootTmp.getNum()) {
                //Lo insertaré por derecha
                if (rootTmp.getDer() == null) {
                    rootTmp.setDer(dato);
                } else {
                    //Llamada recursiva
                    insertar(dato, rootTmp.getDer());
                }
            } else {
                //Lo insertaré por izquierda
                if (dato.getNum() <= rootTmp.getNum()) {
                    //Lo insertaré por derecha
                    if (rootTmp.getIzq() == null) {
                        rootTmp.setIzq(dato);
                    } else {
                        //Llamada recursiva
                        insertar(dato, rootTmp.getIzq());
                    }
                }
            }
        }
    }

    public void listarPost(clsNodo rootTmp) {
        if (rootTmp != null) {
            if (rootTmp.getIzq() != null) {
                listarPost(rootTmp.getIzq());
            }
            if (rootTmp.getDer() != null) {//¿Tiene hijo por derecha? 
                listarPost(rootTmp.getDer());
            }
            System.out.println("Numero: " + rootTmp.getNum());
        }
    }

    public void listarPre(clsNodo rootTmp) {
        if (rootTmp != null) {
            System.out.println("Numero: " + rootTmp.getNum());
            if (rootTmp.getIzq() != null) {
                listarPre(rootTmp.getIzq());
            }
            if (rootTmp.getDer() != null) {//¿Tiene hijo por derecha? 
                listarPre(rootTmp.getDer());
            }
        }
    }

    public void listarIn(clsNodo rootTmp) {
        if (rootTmp != null) {
            if (rootTmp.getIzq() != null) {
                listarIn(rootTmp.getIzq());
            }
            System.out.println("Numero: " + rootTmp.getNum());
            if (rootTmp.getDer() != null) {//¿Tiene hijo por derecha? 
                listarIn(rootTmp.getDer());
            }

        }
    }

    public int calAltura(clsNodo rootTmp) {
        int altura = 0;

        if (getRoot() == null) {
            return altura;
        }

        if (rootTmp.getIzq() != null) {
            altura = Math.max(altura, calAltura(rootTmp.getIzq()));
        }
        if (rootTmp.getDer() != null) {
            altura = Math.max(altura, calAltura(rootTmp.getDer()));
        }
        altura++;

        return altura;
    }
    

    /**
     * @return the root
     */
    public clsNodo getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(clsNodo root) {
        this.root = root;
    }

}
