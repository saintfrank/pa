program
   int l[100];
   int n;
   int iPos;
   int iMin;
   int i;
   int t;
   n := 100;
   while iPos < n do
      iMin := iPos;
      i := iPos;
      while i < n do
         if l[i] < l[iMin] then
	    iMin := i;
	 else
	    skip;
	 fi
	 i := i + 1;
      od
      if iMin != iPos then
         t := l[iPos];
	 l[iPos] := l[iMin];
	 l[iMin] := t;
      else
         skip;
      fi
      iPos := iPos + 1;
   od
end