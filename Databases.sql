/*Q1:*/
SELECT TenantName 
FROM Tenants 
JOIN AptTenants
ON AptTenants.ID = Tenants.ID
GROUP BY TenantID
HAVING count(*)>1


SELECT TenentName
FROM Tenants
JOIN 
(SELECT TenantID FROM AptTenants
GROUP BY TenantID
HAVING count(*)>1) C 
ON Tenants.TenantID = C.TenentID


/*Q2*/:
SELECT BuildingName, ISNULL(Count,0) as 'Count'
FROM Buildings
LEFT JOIN  
(SELECT BuildingID COUNT(RequestID) as 'Count'
FROM Requests JOIN Apartments
ON Requests.AptID = Apartments.AptID
WHERE status = 'Open'
GROUP BY BuildingID) C
ON Buildings.BuildingID = C.BuildingID


/*Q3*/:
UPDATE Resuqests
SET Status = 'Closed'
WHERE AptID IN (SELECT AptID FROM Apartments WHERE BuildingID=11)

