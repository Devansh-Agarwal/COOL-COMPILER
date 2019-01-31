MAKE = make
%: build

build:
	$(MAKE) -C ./src/grammar -f Makefile
	$(MAKE) -C ./src/cpp -f Makefile

clean:
	$(MAKE) -C ./src/grammar -f Makefile clean
	$(MAKE) -C ./src/cpp -f Makefile clean
