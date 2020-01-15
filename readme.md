# Enigma challenge

#### Objectif

During World War II, the Germans were using an encryption code called Enigma – which was basically an encryption machine that encrypted messages for transmission. The Enigma code went many years unbroken. Here's How the basic machine works:  
  
First Caesar shift is applied using an incrementing number:  
If String is  **AAA**  and starting number is  **4**  then output will be  **EFG**.  

**A + 4 = E  
A + 4 + 1 = F  
A + 4 + 1 + 1 = G**

  
Now map  **EFG**  to first ROTOR such as:  

**ABCDEFGHIJKLMNOPQRSTUVWXYZ  
BDFHJLCPRTXVZNYEIWGAKMUSQO**

So  **EFG**  becomes  **JLC**. Then it is passed through 2 more rotors to get the final value.  
  
If the second ROTOR is  **AJDKSIRUXBLHWTMCQGZNPYFVOE**, we apply the substitution step again thus:  

**ABCDEFGHIJKLMNOPQRSTUVWXYZ  
AJDKSIRUXBLHWTMCQGZNPYFVOE**

So  **JLC**  becomes  **BHD**.  
  
If the third ROTOR is  **EKMFLGDQVZNTOWYHXUSPAIBRCJ**, then the final substitution is:  

**ABCDEFGHIJKLMNOPQRSTUVWXYZ  
EKMFLGDQVZNTOWYHXUSPAIBRCJ**

So  **BHD**  becomes  **KQF**.  
  
Final output is sent via Radio Transmitter.