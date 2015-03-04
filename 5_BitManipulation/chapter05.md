## Chapter 05 Bit Manipulation

### bit operation
___________________

* clear the i roghtmost bits of a:    
  a&(~0<<i)

* get i-th bit of a:                  
  a&(1<<i)
  
* set i-th bit of a to 1:            
  a|(1<<i)
  
* clear i-th bit of a to 0:          
  a &= ~(1<<i)s
  
* check if a is a power of 2:       
  ((a & (a-1)) == 0) 
  
* clear the least significant bit in a:     
  a = a & (a-1) 