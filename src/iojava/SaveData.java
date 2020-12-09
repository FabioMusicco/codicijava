package iojava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Item implements Serializable{
	private double num;
	private String str;
	
	
	@Override
	public String toString() {// per leggere la stringa da output
		return "Item [num=" + num + ", str=" + str + "]";
	}
	public Item(String str,double num) {
		this.num = num;
		this.str = str;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}

public class SaveData {

	public static void main(String[] args) throws ClassNotFoundException {
//		Item it1=new Item("CiaoFF",3.456);
//		Item it2=new Item("CiaoMM",3.56);
//		try {//scrive su un file o lo crea
//			DataOutputStream out=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("conti.data")));
//			out.writeUTF(it1.getStr());
//			out.writeDouble(it1.getNum());
//			out.close();
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			DataInputStream in=new DataInputStream(new BufferedInputStream(new FileInputStream("conti.data")));
//			
//			while(in.available()!=0) {
//			
//			String str=in.readUTF();// salva oggetti
//			double num=in.readDouble();
//			Item it4= new Item(str,num);
//			System.out.println(it4);
//			in.close();
//			}
//			in.close();
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		Item it1=new Item("CiaoFF",3.456);
		Item it2=new Item("CiaoMM",3.56);
		List <Item> list_it=new ArrayList<Item>();
		list_it.add(it1);
		list_it.add(it2);
		try {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("oggetti_conti.data",true));
			System.out.println("Salvo la lista "+it1);
			out.writeObject(list_it);
//			System.out.println("Salvo l'oggetto"+it2);
//			out.writeObject(it2); salvataggio singoli oggetti
			out.close();
//		
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("oggetti_conti.data"));
			
			List<Item> list_saved=(List<Item>)in.readObject();
			System.out.println("Carico l'oggetto lista "+list_saved);
//			Item it3=(Item)in.readObject();
//			System.out.println("Carico l'oggetto"+it3);
//			Item it4=(Item)in.readObject();
//			System.out.println("Carico l'oggetto"+it4);
			in.close();
	}
	  catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace(); 
	} 
}
		
	}


