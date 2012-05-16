program
	int i; 
	int a; 
	int b;
	i := 0; 
	a := 2; 
	b := 1;
	while i < 10 do
		a := a*a;
		b := b*i;
		i := i+1;
	od
	write a;
	write b;
end

