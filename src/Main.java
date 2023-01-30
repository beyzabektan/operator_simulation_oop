
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		try {
			PrintStream outstream = new PrintStream(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];

		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		PrintStream outstream1;
		try {
		        outstream1 = new PrintStream(outFile);
		}catch(FileNotFoundException e2) {
		        e2.printStackTrace();
		        return;
		}
		
		int ccount = 0;
		int ocount = 0;
		
		
		for(int i = 0; i < N ; i++) {
			int action = reader.nextInt();
			if (action == 1) {
				customers[ccount] = new Customer(ccount, reader.next(), reader.nextInt(), operators[reader.nextInt()], reader.nextDouble());
				ccount ++;
			}
			
			else if (action == 2) {
				operators[ocount] = new Operator(ocount, reader.nextDouble(), reader.nextDouble(), reader.nextDouble(), reader.nextInt());
				ocount ++;
			}
			
			
			else if (action == 3) {
				Customer firstcustomer = customers[reader.nextInt()];
				Customer secondcustomer = customers[reader.nextInt()];
				int talkingduration = reader.nextInt();
				firstcustomer.talk(talkingduration, secondcustomer);
			}
			
			
			else if (action == 4) {
				Customer firstcustomer = customers[reader.nextInt()];
				Customer secondcustomer = customers[reader.nextInt()];
				int numberofmessages = reader.nextInt();
				firstcustomer.message(numberofmessages, secondcustomer);
				
			}
			
			
			else if (action == 5) {
				Customer firstcustomer = customers[reader.nextInt()];
				double amountofnetwork = reader.nextDouble();
				firstcustomer.connection(amountofnetwork);
			}
			
			
			else if (action == 6) {
				Customer firstcustomer = customers[reader.nextInt()];
				double payingamount = reader.nextDouble();
				firstcustomer.getBill().pay(payingamount);
			}
			
			
			else if (action == 7) {
				Customer firstcustomer = customers[reader.nextInt()];
				Operator operator = operators[reader.nextInt()];
				firstcustomer.setOperator(operator);
			}
			
			
			else if (action == 8) {
				Customer firstcustomer = customers[reader.nextInt()];
				double newlimitamount = reader.nextDouble();
				firstcustomer.getBill().changeTheLimit(newlimitamount);
			}
			
			
		}
		
		for (int i = 0; i < O ; i++) {
			outstream1.print("Operator "+ i + " : ");
			outstream1.println(operators[i].talkingService +" "+ operators[i].messageService +" "+ String.format("%.2f",operators[i].internetService));
			
		}
		
		for (int i = 0; i < C ; i++) {
			outstream1.print("Customer "+ i + " : ");
			outstream1.println(String.format("%.2f",customers[i].getBill().moneySpent) + " " + String.format("%.2f",customers[i].getBill().getCurrentDebt()));
			
		}
		
		Customer maxTalkPerson = customers[0];
		Customer maxMessagePerson = customers[0];
		Customer maxInternetPerson = customers[0];
		
		for (int i = 1; i < C ; i++) {
			if (customers[i].talkingMinute > maxTalkPerson.talkingMinute) {
				maxTalkPerson = customers[i];
			}
		}
		for (int i = 1; i < C ; i++) {
			if (customers[i].messageSent > maxMessagePerson.messageSent) {
				maxMessagePerson = customers[i];
			}
			
		}
		for (int i = 1; i < C ; i++) {
			if (customers[i].internetUsed > maxInternetPerson.internetUsed) {
				maxInternetPerson = customers[i];
			}
			
		}
		
		outstream1.println(maxTalkPerson.name + " : " + maxTalkPerson.talkingMinute);
		outstream1.println(maxMessagePerson.name + " : " + maxMessagePerson.messageSent);
		outstream1.println(maxInternetPerson.name + " : " + String.format("%.2f",maxInternetPerson.internetUsed));
		
		
		
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	} 
}

