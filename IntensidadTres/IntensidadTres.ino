byte intensidad;
int led = 9;
char evento;
//String salidaI;

void setup() {
 Serial.begin(9600);
 pinMode(led, OUTPUT);
}

void loop() {
  if(Serial.available()>0){
    evento = Serial.read();
    //String receivedString = Serial.readStringUntil('\n');
    if(evento == 'e'){
      digitalWrite(led, HIGH);
    } else if (evento == 'i'){
      String receivedString = Serial.readStringUntil('\n');
      //while (evento == 'i'){
      int intensidad = receivedString.toInt(); //convertir string a int
      if(intensidad >=0 && intensidad <= 255){
        analogWrite(led, intensidad);
      }
      /*if(salidaI<10){
            c = c + "00" + salidaI;
        } else if(salidaI < 100){
            d = d + "0" + salidaI;
        } else{
            u = u + salidaI;
        }
     /* delay(20);
      c = Serial.read();
      delay(20);
      d = Serial.read();
      delay(20);
      u= Serial.read();*/
      /*t=(100*c)+(10*d)+u;
      
      analogWrite(led, t);
      //break;
      //}*/
    } else {
      digitalWrite(led, LOW);
    }
  }

}
