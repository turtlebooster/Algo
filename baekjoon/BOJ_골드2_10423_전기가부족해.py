import heapq

class Edge:
    def __init__(self, e, w):
        self.e = e
        self.w = w

    def __lt__(self, other):
        return self.w < other.w


def solution():
    # 도시 개수, 설치 가능 케이블 수, 발전소 개수 입력
    N, M, K = map(int, input().split())

    # 발전소 입력
    power = list(map(int, input().split()))

    # 인접 리스트
    adj_list = [[] for _ in range(N + 1)]

    # 그래프 입력
    for _ in range(M):
        u, v, w = map(int, input().split())
        adj_list[u].append(Edge(v, w))
        adj_list[v].append(Edge(u, w))

    visited = [False for _ in range(N + 1)]
    pq = []

    cnt = len(power)
    ans = 0
    for p in power:
        visited[p] = True
        for e in adj_list[p]:
            heapq.heappush(pq, e)

    while pq:
        curr = heapq.heappop(pq)

        if visited[curr.e]:
            continue
        visited[curr.e] = True

        ans += curr.w
        cnt += 1
        if cnt >= N:
            break
        for e in adj_list[curr.e]:
            heapq.heappush(pq, e)

    return ans


if __name__ == '__main__':
    print(solution())
