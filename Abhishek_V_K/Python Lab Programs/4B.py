import re

def count_occurrences(text):
  vowel_count = len(re.findall(r'[aeiouAEIOU]', text))
  consonant_count = len(re.findall(r'[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z]', text))
  digit_count = len(re.findall(r'\d', text))
  return {'vowels': vowel_count, 'consonants': consonant_count, 'digits': digit_count}

text = "This is a sample text with vowels, consonants and digits. 123"
counts = count_occurrences(text)
print("Vowels:", counts['vowels'])
print("Consonants:", counts['consonants'])
print("Digits:", counts['digits'])

