use std::io::{self, Read, Write};

fn main() {
    println!("File Encryptor!");
    println!("1. Encrypt a File");
    println!("2. Decrypt a File");
    print!("Choose an option: ");
    io::stdout().flush().unwrap();

    let mut choice = String::new();
    io::stdin().read_line(&mut choice).unwrap();

    if choice != "1" && choice != "2"{
        println!("Not a valid choice!");
        return;
    }

}
