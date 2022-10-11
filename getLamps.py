def getLamps(intervals, coors):
    shineTime = {}
    for interval in intervals:
        for i in range(interval[0], interval[1] + 1):
            if i in shineTime:
                shineTime[i] += 1
            else:
                shineTime[i] = 1
    result = []
    for coor in coors:
        if coor in shineTime:
            result.append(shineTime[coor])
        else:
            result.append(0)
    return result

def main():
    intervals = [[1, 4], [2, 5]]
    coors = [1, 3, 7]
    print(getLamps(intervals, coors))

if __name__ == "__main__":
    main()