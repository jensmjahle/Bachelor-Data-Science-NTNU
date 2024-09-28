//*************Task 4*************//
#include <iostream>
#include <string>

using namespace std;

void task_4() {
  // a) Les inn tre ord fra brukeren
  std::string word_1, word_2, word_3;

  cout << "Skriv inn første ord: ";
  cin >> word_1;
  cout << "Skriv inn andre ord: ";
  cin >> word_2;
  cout << "Skriv inn tredje ord: ";
  cin >> word_3;

  // b) Skjøt sammen ordene med mellomrom og punktum, skriv ut setningen
  std::string sentence = word_1 + " " + word_2 + " " + word_3 + ".";
  cout << "Setning: " << sentence << endl;

  // c) Skriv ut lengden til hvert enkelt ord og lengden på setningen
  cout << "Lengde på første ord: " << word_1.size() << endl;
  cout << "Lengde på andre ord: " << word_2.size() << endl;
  cout << "Lengde på tredje ord: " << word_3.size() << endl;
  cout << "Lengde på setningen: " << sentence.size() << endl;

  // d) Lag en kopi av sentence
  std::string sentence2 = sentence;

  // e) Bytt ut tegn nr 10-12 i sentence2 med x’er
  if (sentence2.size() >= 12) {
    sentence2[9] = 'x';
    sentence2[10] = 'x';
    sentence2[11] = 'x';
  }
  cout << "Original setning: " << sentence << endl;
  cout << "Modifisert setning: " << sentence2 << endl;

  // f) Lagre de fem første tegnene i sentence i objektet sentence_start
  std::string sentence_start = sentence.substr(0, 5); // Hent de 5 første tegnene
  cout << "De fem første tegnene: " << sentence_start << endl;

  // g) Finn ut om sentence inneholder ordet "hallo"
  if (sentence.find("hallo") != std::string::npos) {
    cout << "Setningen inneholder ordet 'hallo'." << endl;
  } else {
    cout << "Setningen inneholder ikke ordet 'hallo'." << endl;
  }

  // h) Finn alle forekomster av strengen "er" i sentence
  size_t pos = sentence.find("er");
  while (pos != std::string::npos) {
    cout << "'er' funnet på posisjon: " << pos << endl;
    pos = sentence.find("er", pos + 1);
  }
}
