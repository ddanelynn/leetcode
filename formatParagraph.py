def formatParagraph(wordList, width):
    formatted = []
    formatted.append("******************")
    for para in wordList:
        line = ""
        for word in para:
            if len(line) - 1 + len(word) > width:
                difference = width - len(line) + 1
                if difference:
                    if difference%2 == 0:
                        line = difference/2 * " " + line + (difference/2 - 1) * " "
                    else:
                        line = int(difference/2) * " " + line + int(difference/2) * " "
                else:
                    line = line[:len(line) - 1]
                formatted.append("*" + line + "*")
                line = word + " "
            else:
                line += word + " "
        if len(line):
            difference = width - len(line) + 1
            if difference:
                if difference%2 == 0:
                    print(difference/2)
                    line = difference/2 * " " + line + (difference/2 - 1) * " "
                else:
                    line = int(difference/2) * " " + line + int(difference/2) * " "
            else:
                line = line[:len(line) - 1]
            formatted.append("*" + line + "*")
    formatted.append("******************")
    return formatted

def main():
    wordList = [
    ["I", "hate", "coding", "interview"],
    ["But", "I", "need", "a", "job"]]
    print(formatParagraph(wordList, 16))

if __name__ == "__main__":
    main()
