package DSProject;
import java.util.HashMap;
public class CityGraph
{
   HashMap<String , Node> nodes = new HashMap<>();
   HashMap<String , Edge> edges = new HashMap<>();
   HashMap<String , Person> persons = new HashMap<>();
   HashMap<String , BankAccount>  bankAccounts= new HashMap<>();
   HashMap<String , Call> calls = new HashMap<>();
   HashMap<String , Car> cars = new HashMap<>();
   HashMap<String , Home> homes = new HashMap<>();
   HashMap<String , Own> owns =new HashMap<>();
   HashMap<String , Mobile> mobiles = new HashMap<>();
   HashMap<String , Relation> relations =new HashMap<>();
   HashMap<String , Transaction> transactions =new HashMap<>();
   //-------------add nodes-------------------
   void add_nodes(Node n){
      nodes.put(n.key, n);
   }

   void add_person(Person p){
      persons.put(p.key, p);
      this.add_nodes(p);
   }
   void add_bankAccount(BankAccount ba){
      bankAccounts.put(ba.key, ba);
      this.add_nodes(ba);
   }
   void add_mobile(Mobile m){
      mobiles.put(m.key, m);
      this.add_nodes(m);
   }
   void add_car(Car c){
      cars.put(c.key, c);
      this.add_nodes(c);
   }
   void add_home(Home h){
      homes.put(h.key, h);
      this.add_nodes(h);
   }
   //-----------add edges-----------------
   void add_edge(Edge e){
      edges.put(e.key, e);
   }
   void add_call(String[] c){
      Mobile from = get_mobile(c[0]);
      Mobile to = get_mobile(c[1]);
      Call call = new Call(from , to , c[2] , c[3] , c[4]);
      from.connect(to , call);
      edges.put(call.key , call);
   }
   void add_own(String[] o){
      Person person = get_person(o[0]);
      Car car = get_car(o[1]);
      Home home = get_home(o[1]);
      Own own;
      if (car==null)
      {
         own = new Own(person,home , o[2] , o[3] , o[4]);
         person.connect(home , own);
      }
      else
      {
         own = new Own(person,car , o[2] , o[3] , o[4]);
         person.connect(car , own);
      }
      edges.put(own.key , own);
   }
   void add_relation(String[] r){
      Person from = get_person(r[0]);
      Person to = get_person(r[1]);
      Relation rel1 = new Relation(from , to , r[2] , r[3]);
      Relation rel2 = new Relation(from , to , r[2] , r[3]);
      from.connect(to , rel1);
      to.connect(from , rel2);
      edges.put(rel1.key , rel1);
      edges.put(rel2.key , rel2);
   }
   void add_transaction(String[] t){
      BankAccount from = get_bankAccount(t[0]);
      BankAccount to = get_bankAccount(t[1]);
      Transaction transaction = new Transaction(from , to , t[2] , t[3] , t[4]);
      from.connect(to , transaction);
      edges.put(transaction.key , transaction);
   }

   //---------------get nodes------------------
   Node get_node(String k){
      return nodes.get(k);
   }
   Person get_person(String k){
      return persons.get(k);
   }
   BankAccount get_bankAccount(String k){
      return bankAccounts.get(k);
   }
   Mobile get_mobile(String k){
      return mobiles.get(k);
   }
   Car get_car(String k){
      return cars.get(k);
   }
   Home get_home(String k){
      return homes.get(k);
   }
   //-----------get edges-----------------
   Edge get_edge(String k){
      return edges.get(k);
   }
   Call get_call(String k){ return calls.get(k); }
   Own get_own(String k){
      return owns.get(k);
   }
   Relation get_relation(String k){
      return relations.get(k);
   }
   Transaction get_transaction(String k){
      return transactions.get(k);
   }
}