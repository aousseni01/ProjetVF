/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author GWENDOLINE
 */
public class PivotGauss {
    
 public static void affichageVecteur(double [] t) {
    for ( int i = 0 ; i < t.length ; i++ ) {
      System.out.println(t[i]); 
    }
    System.out.println("");
  }
  

 
  public static void affichageMatrice(double [][] t) {
      NumberFormat formatter = new DecimalFormat("#0.00");
      for (double[] t1 : t) {
          for (int j = 0; j < t1.length; j++) {
              System.out.print(formatter.format(t1[j])+" | ");
          }
          System.out.println("");
      }
      System.out.println("");
  }
  

  static double [] produit(double [][] m,double [] v) {
    double [] w = new double[v.length];
    for ( int i = 0 ; i < v.length ; i++ ) {
      w[i] = 0.0;
      for ( int j = 0 ; j < v.length ; j++ ) {
        w[i] = w[i] + m[i][j]*v[j]; } }
    return w;
  }
  

//Deux méthodes permettant respectivement de cloner un vecteur et une matrice
//Cela nous permet de garder la matrice et le vecteur initial
  static double [] cloneVecteur(double [] t) { 
    int n = t.length;
    double [] nt = new double[n];
    for ( int i = 0 ; i < n ; i++ ) {
      nt[i] = t[i]; }
    return nt;
  }


  static double [][] cloneMatrice(double [][] t) {
    int n = t.length;
    int m = t[0].length;
    double [][] nt = new double[n][m];
    for ( int i = 0 ; i < n ; i++ ) {
      for ( int j = 0 ; j < m ; j++ ) {
        nt[i][j] = t[i][j]; } }
    return nt;
  }


  static void permutation(int l,double [][] a,double [] b) {
    int n = b.length;
    double aux;
    int ll = l;
    while ( a[ll][l] == 0.0 ) {
      ll++; }
    for ( int i = l ; i < n ; i++ ) {
      aux = a[l][i];
      a[l][i] = a[ll][i];
      a[ll][i] = aux; }
    aux = b[l];
    b[l] = b[ll];
    b[ll] = aux;
  }

//diagonalisation de la matrice
  static void transformation(double [][] a,double [] b) {
    int n = b.length;
    for ( int i = 1 ; i < n ; i++ ) {
      if ( a[i-1][i-1] == 0.0 )
        permutation(i-1,a,b);
      for ( int j = i ; j < n ; j++ ) {
        double facteur = a[j][i-1]/a[i-1][i-1];
        for ( int k = i-1 ; k < n ; k++ ) {
          a[j][k] = a[j][k] - a[i-1][k]*facteur; }
        b[j] = b[j] - b[i-1]*facteur;  } }
  }


  
  static double [] extraction(double [][] a,double [] b) {
    int n = b.length;
    double [] v = new double[n];
    v[n-1] = b[n-1]/a[n-1][n-1];
    for ( int i = n-2 ; i >= 0 ; i-- ) {
      v[i] = b[i];
      for ( int j = n-1 ; j > i ; j-- ) {
        v[i] = v[i] - v[j]*a[i][j]; }
      v[i] = v[i]/a[i][i]; }
    return v;
  }



  static double [] resolution(double [][] a, double [] b) {
    transformation(a,b);
    return extraction(a,b);
  }
  


  static double [] resolutionGauss(double [][] a, double [] b) {
    return resolution(cloneMatrice(a),cloneVecteur(b));
  }


  public static double [] resoudreSysteme(double [][] a,double [] b) {
    double [] v; 
    v = resolutionGauss(a,b);
    return v;
    }
}
