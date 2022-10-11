def getMinLampIndex(coords, radius):
    index = coords[0] - radius
    leftLimit = index - radius
    rightLimit = index + radius
    leftIndex = 0
    rightIndex = 0
    count = 1
    maxCount = count
    for i in range(index + 1, len(coords)):
        leftLimit += 1
        rightLimit += 1
        while (leftIndex <= i) and (coords[leftIndex] < leftLimit):
            leftIndex += 1

        while (rightIndex < len(coords) - 1) and (coords[rightIndex + 1] <= rightLimit):
            rightIndex += 1
        count = rightIndex - leftIndex + 1
        if count > maxCount:
            maxCount = count
            index = i
    return index

def main():
    coords = [-4, -1, 0, 3, 4]
    print(getMinLampIndex(coords, 3))

if __name__ == "__main__":
    main()