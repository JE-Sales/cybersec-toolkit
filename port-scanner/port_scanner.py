import socket

def scan_port(ip, port):
    try:
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        sock.settimeout(1)
        result = sock.connect_ex((ip,port))
        if(result == 0):
            print(f"[+] Port {[port]} is open")
        sock.close()
    except Exception as e:
        print(f"[-] Eerror scanning port {port}: {e}")

def main():
    target = input("Enter IP address to scan: ").strip()

    start_port = int(input("Start port: "))
    end_port  = int(input("End port: "))

    print*(f"\n Scanning {target} from port {start_port} to {end_port}...\n")

    for port in range(start_port, end_port + 1):
        scan_port(target, port)

if __name__ == "__main__":
    main()